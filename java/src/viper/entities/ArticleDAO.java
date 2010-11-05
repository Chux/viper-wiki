package viper.entities;

import java.util.Date;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import viper.db.HibernateUtil;
import viper.abstracts.HibernateDAO;
import viper.abstracts.ResourceElement;

public class ArticleDAO extends HibernateDAO{

	@Override
	public String getClassNameOfDAOResource() {
		return Article.class.getName();
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


	@Override
	public ResourceElement createElement(Map<String,String[]> parameterMap) {
		Article article = null;
		if (parameterMap.containsKey("title") && parameterMap.containsKey("content")) {
			article = new Article();
			article.setTitle(parameterMap.get("title")[0]);
			article.setContent(parameterMap.get("content")[0]);
			Date datetime = new Date();
			article.setDatetime(datetime);
			this.createElement(article);
		} 	
		
		
		return article;
	}
	

}
