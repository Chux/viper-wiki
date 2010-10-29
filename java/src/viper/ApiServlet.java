package viper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import viper.entities.Article;
import viper.entities.ArticleDAO;


/**
 * Servlet implementation class ApiServlet
 * @param <viperSession>
 */
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ApiServlet() {
    	//super();
    }
    
	public void init(ServletContext servletContext) {
		File configfile = new File(servletContext.getRealPath("/WEB-INF/hibernate/hibernate.cfg.xml"));
		viper.db.HibernateUtil.initHibernate(configfile);
	}
	
	private viperSession getViperSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		viperSession vs = (viperSession) session.getAttribute("session");  
		if(vs == null) {
			vs = new viperSession();
			ArrayList<Article> articlesDb = new ArrayList<Article>();
			vs.setAllArticles(articlesDb);
			session.setAttribute("session", vs);
		}
		return vs;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init(this.getServletContext());
		viperSession vs = getViperSession(request);
		
		request.getRequestDispatcher("WEB-INF/jsp/Article.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//init(this.getServletContext());		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Article na = new Article();
		na.setTitle(title);
		na.setContent(content);
		
		ArticleDAO.saveArticle(na);
		
		viperSession vs = getViperSession(request);
		vs.setAllArticles(ArticleDAO.getAllArticles());
		
		request.getRequestDispatcher("WEB-INF/jsp/Article.jsp").include(request, response);
	}

}
