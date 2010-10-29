package viper.entities;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import viper.db.HibernateUtil;

public class ArticleDAO {

	@SuppressWarnings("unchecked")
	public static List<Article> getAllArticles() {
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		
		Query query = hibernateSession.createQuery("from viper.entities.Article");
		
		hibernateSession.getTransaction().commit();
		
		List<Article> articles = query.list();
		
		return articles;
		
	}
	
	public static void saveArticle(Article a) {
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		
		hibernateSession.save(a);
		
		hibernateSession.getTransaction().commit();
		
	}

	
}
