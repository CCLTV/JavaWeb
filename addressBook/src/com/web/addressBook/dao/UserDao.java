package com.web.addressBook.dao;

import java.sql.SQLException;

import com.web.addressBook.domain.User;
import com.web.addressBook.domain.addressBook;

public interface UserDao {
	/**
	 * 简单返回验证 Boolean\
	 * @param userName
	 * @param password
	 * 
	 * @return  true :登陆成功，false : 登陆失败
	 * 
	 */
	boolean  login(String userName,String password) ;
	
	/**
	 * 添加学生
	 * @param student 需要添加到数据库的学生对象
	 * @throws SQLException
	 */
	void insert(User user) throws SQLException ;
	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update (User user )throws SQLException ;
	
}
