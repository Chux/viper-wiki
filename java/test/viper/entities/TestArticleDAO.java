package viper.entities;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestArticleDAO {

	@Before
	public void setUp() throws Exception {
		File configfile = new File("/Users/ollesvensson/Programering/PortningsKurs2/viper-wiki/java/WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		viper.db.HibernateUtil.initHibernate(configfile);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllArticles() {
		ArticleDAO ad = new ArticleDAO();
		Article article = new Article();
		article.setContent("olle");
		assertEquals("olle", article.getContent());
		//ArticleDAO.saveArticle(article); 
		List<Article> articles = ArticleDAO.getAllArticles();
		assertEquals("olle", articles.get(0).getContent());
	}



}
