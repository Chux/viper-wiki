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
import viper.interfaces.HibernateDAO;
import viper.interfaces.OutputCreator;
import viper.interfaces.ResourceElement;

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

	private viperSession getViperSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		viperSession vs = (viperSession) session.getAttribute("session");
		if (vs == null) {
			vs = new viperSession();
			ArrayList<Article> articlesDb = new ArrayList<Article>();
			vs.setAllArticles(articlesDb);
			session.setAttribute("session", vs);
		}
		return vs;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		
		System.out.println("urimap" + uriMapResource);
		String[] uriArray = splitUri(request.getRequestURI());
		if (uriArray[2].equals("API")) {			
			if (uriMapResource.containsKey(uriArray[3])) {
				HibernateDAO resourceDAO = uriMapResource.get(uriArray[3]);

				if (uriArray.length > 4) {
					ResourceElement resource = resourceDAO.getElement(Integer.parseInt(uriArray[4]));
					response.getWriter().print(resource.toJsonString());

				} else {
					List<ResourceElement> resourceCollection = resourceDAO.getCollection();
					String json = "[";
					for (int i = 0; i < resourceCollection.size(); i++) {
						if (i == 0) {
							json += resourceCollection.get(i).toJsonString();
						} else {
							json += "," + resourceCollection.get(i).toJsonString();
						}
					}
					json += "]";
					response.getWriter().print(json);
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// init(this.getServletContext());

		/*
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("content");
		 * 
		 * Article na = new Article(); na.setTitle(title);
		 * na.setContent(content);
		 * 
		 * ArticleDAO.saveArticle(na);
		 * 
		 * viperSession vs = getViperSession(request);
		 * vs.setAllArticles(ArticleDAO.getAllArticles());
		 * 
		 * request.getRequestDispatcher("WEB-INF/jsp/Article.jsp").include(
		 * request, response);
		 */
	}

	private String[] splitUri(String uri) {

		String[] list = uri.split("/");
		return list;
	}

}
