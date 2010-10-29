package viper.db;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import viper.entities.User;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void initHibernate(File configFile) {
		if (null == sessionFactory) {
			AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration()
					.addAnnotatedClass(User.class).configure(configFile);
			sessionFactory = annotationConfiguration.buildSessionFactory();
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public static Session getSession() {

		return sessionFactory.openSession();
	}
}
