package vipertests;

import static org.junit.Assert.*;

import java.io.File;

import org.hibernate.Session;
import org.junit.Test;

import viper.db.HibernateUtil;

public class TestHibernateConfiguration {

	@Test
	public void SessionOpen() {
		
		File configfile = new File("WebContent/WEB-INF/hibernate/hibernate.cfg.xml");
		viper.db.HibernateUtil.initHibernate(configfile);
		
		Session hibernateSession = HibernateUtil.getSession();
		
		hibernateSession.beginTransaction();
		assertTrue( hibernateSession.isOpen() );
		
	}
	
}
