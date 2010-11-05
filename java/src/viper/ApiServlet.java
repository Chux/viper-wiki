package viper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import viper.entities.Article;
import viper.entities.ArticleDAO;
import viper.abstracts.HibernateDAO;
import viper.abstracts.ResourceElement;

/**
 * Servlet implementation class ApiServlet
 * 
 * @param <viperSession>
 */
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, HibernateDAO> uriMapResource;

	/**
	 * Default constructor.
	 */
	public ApiServlet() {
		uriMapResource = new HashMap<String, HibernateDAO>();
		HibernateDAO articleDAO = new ArticleDAO();
		uriMapResource.put("article", articleDAO);
	}

	public void init(ServletContext servletContext) {
		File configfile = new File(
				servletContext
						.getRealPath("/WEB-INF/hibernate/hibernate.cfg.xml"));
		viper.db.HibernateUtil.initHibernate(configfile);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());

		String[] uriArray = splitUri(request.getRequestURI());
		if (uriArray[2].equals("API")) {
			if (uriArray.length > 3) {
				if (uriMapResource.containsKey(uriArray[3])) {
					HibernateDAO resourceDAO = uriMapResource.get(uriArray[3]);

					if (uriArray.length > 4) {
						try {
							ResourceElement resource = resourceDAO
									.getElement(Integer.parseInt(uriArray[4]));
							response.setStatus(HttpServletResponse.SC_OK);
							response.getWriter().print(resource.toJsonString());
						} catch (Exception e) {
							response.setStatus(HttpServletResponse.SC_NOT_FOUND);
						}
					} else {
						try {
							List<ResourceElement> resourceCollection = resourceDAO
									.getCollection();
							String json = "[";
							for (int i = 0; i < resourceCollection.size(); i++) {
								if (i == 0) {
									json += resourceCollection.get(i)
											.toJsonString();
								} else {
									json += ","
											+ resourceCollection.get(i)
													.toJsonString();
								}
							}
							json += "]";
							response.setStatus(HttpServletResponse.SC_OK);
							response.getWriter().print(json);
						} catch (Exception e) {
							response.setStatus(HttpServletResponse.SC_NOT_FOUND);
						}
					}
				}
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		String[] uriArray = splitUri(request.getRequestURI());
		if (uriArray.length > 2 && uriArray[2].equals("API")) {
			if (uriMapResource.containsKey(uriArray[3])) {
				HibernateDAO resourceDAO = uriMapResource.get(uriArray[3]);
				try {
					ResourceElement resource = resourceDAO
							.createElement(request.getParameterMap());
					response.setStatus(HttpServletResponse.SC_CREATED);
				} catch (Exception e) {
					response.sendError(
							HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
							"the wourld has come to an end");
				}
			} else {
				response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED,
						"the wourld has come to an end");
			}
		}
	}

	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		String[] uriArray = splitUri(request.getRequestURI());
		if (uriArray[2].equals("API")) {
			if (uriMapResource.containsKey(uriArray[3])) {
				response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED); // Not
																			// implemented
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
		}
	}

	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		String[] uriArray = splitUri(request.getRequestURI());
		if (uriArray[2].equals("API")) {
			if (uriMapResource.containsKey(uriArray[3])) {
				response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
		}
	}

	private String[] splitUri(String uri) {
		String[] list = uri.split("/");
		return list;
	}

}
