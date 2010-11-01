package viper;

import java.io.File;
import java.util.List;

import org.hibernate.Session;

import viper.db.HibernateUtil;
import viper.entities.Article;
import viper.entities.ArticleDAO;
import viper.entities.UserDAO;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		File configfile = new File("/Users/ollesvensson/Programering/PortningsKurs2/viper-wiki/java/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		File configfile = new File("WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		viper.db.HibernateUtil.initHibernate(configfile);
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		Article article = (Article) hibernateSession.load(Article.class, 1 );
		Article article2 = new Article();
		UserDAO userDAO = new UserDAO();
		System.out.println(userDAO.getClassNameOfDAOResource());
		article2.setTitle("olle");
		article2.setContent("Stortån gör inte ont");
		hibernateSession.save(article2);
		System.out.println(article.getContent());
		//Queryquery = hibernateSession.createQuery("from viper.entities.Article");
		
		//hibernateSession.getTransaction().commit();
		
	//	List<Article> articles = query.list();
		
	}

}
