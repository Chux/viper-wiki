package viper.interfaces;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import viper.db.HibernateUtil;
import viper.entities.User;

public abstract class HibernateDAO {
	
	public abstract String getClassNameOfDAOResource();
	
	public ResourceElement getElement(int identifier){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		ResourceElement  element= (ResourceElement) herbSession.load(User.class, identifier);
		herbSession.getTransaction().commit();
		return element;
	}
	
	
	public List<ResourceElement> getCollection(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery(""); //TODO fix right query elementCollection
		
		herbSession.getTransaction().commit();
		List<ResourceElement> collection = query.list();
		return collection; 
	}
	
	public static void updateElement(ResourceElement element){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		herbSession.save(element);
		
		herbSession.getTransaction().commit();

		return null;
		
	}
	
	public static void updateCollection(List<ResourceElement> collection){
		
	}
	
	public static void createElement(ResourceElement element){
		
	}
	
	public static void createCollection(List<ResourceElement> collection){
		
	}
	
	public static void deleteElement(ResourceElement element){
		
	}
	
	public static void deleteCollection(List<ResourceElement> collection){
		
	}
	
}
