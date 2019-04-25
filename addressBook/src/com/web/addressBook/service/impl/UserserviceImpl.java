package com.web.addressBook.service.impl;

import java.sql.SQLException;

import com.web.addressBook.dao.UserDao;
import com.web.addressBook.dao.impl.UserDaoImpl;
import com.web.addressBook.domain.User;
import com.web.addressBook.service.Userservice;

public class UserserviceImpl implements Userservice {

	@Override
	public boolean login(String userName, String password) {
		UserDao dao = new UserDaoImpl();
		return dao.login(userName, password);
	}

	@Override
	public void insert(User user) throws SQLException {
		UserDao dao = new UserDaoImpl();
		dao.insert(user);	
	}

	@Override
	public void update(User user) throws SQLException {
		UserDao dao = new UserDaoImpl();
		dao.update(user);
		
	}

}
