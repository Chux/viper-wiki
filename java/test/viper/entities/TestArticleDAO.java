package viper.entities;

import static org.junit.Assert.*;

import java.io.File;

import org.hibernate.Session;
import org.junit.Test;

import viper.db.HibernateUtil;

public class TestArticleDAO {

	@Test
	public void GetElement() {
		
		File configfile = new File("WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		viper.db.HibernateUtil.initHibernate( configfile );
		
		ArticleDAO aDAO = new ArticleDAO();
		Article art = (Article) aDAO.getElement( 1 );
		assertTrue( art.getId() == 1 );
		
	}
	
	@Test
	public void GetElementByTitle() {
		
		File configfile = new File("WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		viper.db.HibernateUtil.initHibernate( configfile );
		
		ArticleDAO aDAO = new ArticleDAO();
		
		Article art = (Article) aDAO.getElementByTitle("apa");
		
		System.out.println(art.getId());
		
		
	}	

}
