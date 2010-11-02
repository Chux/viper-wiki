package vipertests;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.instrument.IllegalClassFormatException;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import viper.db.HibernateUtil;
import viper.entities.Article;
import viper.interfaces.HibernateDAO;
import viper.interfaces.ResourceElement;


public class TestHibernateDAO {

	@Test
	public void Basic() {
		
		File configfile = new File("WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		viper.db.HibernateUtil.initHibernate( configfile );
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();

		// Add an article so we have some test data, we'll try to remove it later
		Article testArticle = new Article();
		testArticle.setTitle("Test article");
		testArticle.setContent("This is the content field. Created in TestHibernateDAO.java");
		
		// So to not depend on ArticleDAO we set getClassNameOfDAOResource here
		HibernateDAO hDAO = new HibernateDAO() {			
			@Override
			public String getClassNameOfDAOResource() {
				return Article.class.getName();
			}
		};

		// Testing creation of resourceelement
		List<ResourceElement> articleCollection = hDAO.getCollection();
		int sizeBeforeCreation = articleCollection.size();
		hDAO.createElement( testArticle );
		articleCollection = hDAO.getCollection();
		assertTrue( sizeBeforeCreation < articleCollection.size() );
		
		// Testing the "get ResourceType of DAO" method
		assertEquals( hDAO.getClassNameOfDAOResource(), Article.class.getName() );
		
		// Testing "get element" method
		Article fetchedArticle = (Article) hDAO.getElement( testArticle.getId() );
		assertTrue( fetchedArticle.getId() == testArticle.getId() );
		
		// Testing deletion of resourceelements
		articleCollection = hDAO.getCollection();
		int sizeBeforeDeletion = articleCollection.size();
		assertTrue( sizeBeforeDeletion > 0 );
		try { 
			hDAO.deleteElement( testArticle );
		} 	catch( IllegalClassFormatException e )  {
			
		}
		articleCollection = hDAO.getCollection();
		assertTrue( sizeBeforeDeletion > articleCollection.size() );
		
	}

}
