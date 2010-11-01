package viper.entities;

import viper.interfaces.HibernateDAO;

public class UserDAO extends HibernateDAO {

	@Override
	public String getClassNameOfDAOResource() {
		return User.class.getName();
	}

	
}
