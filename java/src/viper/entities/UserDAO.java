package viper.entities;

import viper.abstracts.HibernateDAO;

public class UserDAO extends HibernateDAO {

	@Override
	public String getClassNameOfDAOResource() {
		return User.class.getName();
	}

	
}
