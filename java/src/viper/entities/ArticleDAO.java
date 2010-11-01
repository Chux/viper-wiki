package viper.entities;

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

	
	@SuppressWarnings("unchecked")
	public static Article getArticleByTitle( String artTitle) {
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		
		Query query = hibernateSession.createQuery("from Article article where article.title = :artTitle");
		
		query.setString("artTitle", artTitle);
		
		hibernateSession.getTransaction().commit();
		
		Article article = (Article) query.list();
		
		return article;
		
	}
	

}
