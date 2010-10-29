package viper.db;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import viper.entities.Article;

public class HibernateUtil {

private static SessionFactory mSessionFactory = null;
	
	public static void initHibernate(File configfile){
		if (null == mSessionFactory) {
			AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration()
							.addAnnotatedClass(Article.class)
							//.addAnnotatedClass(User.class)
							//.addAnnotatedClass(Tag.class)
							.configure(configfile);
			mSessionFactory = annotationConfiguration.buildSessionFactory();
		}
	}
	
	public SessionFactory getSessionFactory() {
		
		return mSessionFactory;		
	}
	
	public static Session getSession(){
		return mSessionFactory.openSession();
	}
	
}
