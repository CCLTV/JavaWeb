package com.web.addressBook.dao;

import java.sql.SQLException;

import com.web.addressBook.domain.User;
import com.web.addressBook.domain.addressBook;

public interface UserDao {
	/**
	 * �򵥷�����֤ Boolean\
	 * @param userName
	 * @param password
	 * 
	 * @return  true :��½�ɹ���false : ��½ʧ��
	 * 
	 */
	boolean  login(String userName,String password) ;
	
	/**
	 * ���ѧ��
	 * @param student ��Ҫ��ӵ����ݿ��ѧ������
	 * @throws SQLException
	 */
	void insert(User user) throws SQLException ;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student ��Ҫ���µ�ѧ������
	 * @throws SQLException
	 */
	void update (User user )throws SQLException ;
	
}
