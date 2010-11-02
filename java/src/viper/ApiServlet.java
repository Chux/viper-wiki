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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		
	}

	private String[] splitUri(String uri) {
		String[] list = uri.split("/");
		return list;
	}

}
