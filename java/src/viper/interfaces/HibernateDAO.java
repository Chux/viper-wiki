package viper.interfaces;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import viper.db.HibernateUtil;
import viper.entities.User;

public abstract class HibernateDAO {
	
	/**
	 * Implement this for connection with a resource.
	 * Standard implementation is : return [Resource].class.getName() 
	 */
	public abstract String getClassNameOfDAOResource();
	
	/**
	 * Get a Resource Element
	 * @param id resource id
	 * @return instance of resource id
	 */
	public ResourceElement getElement(int id){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		ResourceElement  element= (ResourceElement) herbSession.load(this.getClassNameOfDAOResource(), id);
		herbSession.getTransaction().commit();
		return element;
	}
	
	/**
	 * Get all Resourse as a Collection from db 
	 * @param id resource id
	 * @return instance of resource id
	 */
	public List<ResourceElement> getCollection(){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();

		Query query = herbSession.createQuery(""); //TODO fix right query elementCollection
		
		herbSession.getTransaction().commit();
		List<ResourceElement> collection =query.list();
		return collection; 
	}
	
	/**
	 * Update a Resourse in the db 
	 * @param element instance 
	 */
	public static void updateElement(ResourceElement element){
		Session herbSession = HibernateUtil.getSession();
		herbSession.beginTransaction();
		herbSession.save(element);
		herbSession.getTransaction().commit();
	}
	
	public static void updateCollection(List<ResourceElement> collection){
		
	}
	
	/**
	 * Update a Resourse in the db 
	 * @param element instance 
	 */
	public static void createElement(ResourceElement element){
		updateElement(element);
	}
	
	public static void createCollection(List<ResourceElement> collection){
		
	}
	
	public static void deleteElement(ResourceElement element){
		
	}
	
	public static void deleteCollection(List<ResourceElement> collection){
		
	}
	
}
