package viper.entities;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import viper.db.HibernateUtil;
import viper.abstracts.HibernateDAO;
import viper.abstracts.ResourceElement;

public class ArticleDAO extends HibernateDAO {

	@Override
	public String getClassNameOfDAOResource() {
		return Article.class.getName();
	}

	public Article getElementByTitle( String articleTitle ) {
		
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		
		Query query = hibernateSession.createQuery( "from articles as article " +
													"where article.title='" + articleTitle + "' " + 
													"group by article.title ");
		
		return (Article) query.uniqueResult();
	}
	

}
