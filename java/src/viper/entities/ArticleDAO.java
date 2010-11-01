package viper.entities;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import viper.db.HibernateUtil;
import viper.interfaces.HibernateDAO;
import viper.interfaces.ResourceElement;

public class ArticleDAO extends HibernateDAO{

	@Override
	public String getClassNameOfDAOResource() {
		return ResourceElement.class.getName();
	}
/*
	
	@SuppressWarnings("unchecked")
	public static List<Article> getAllArticles() {
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		List<Article> articles = (List<Article>) hibernateSession.load(Article.class, 0 );
		//Query query = hibernateSession.createQuery("from viper.entities.Article");
		
		hibernateSession.getTransaction().commit();
		
	//	List<Article> articles = query.list();
		
		return articles;
		
	}
	
	public static void saveArticle(Article a) {
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		
		hibernateSession.save(a);
			
		hibernateSession.getTransaction().commit();
		
	}*/


	
}
