package com.web.addressBook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.web.addressBook.dao.UserDao;
import com.web.addressBook.domain.User;
import com.web.addressBook.domain.addressBook;
import com.web.addressBook.util.JDBCUtil02;


public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String userName,String password) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			
			 conn =  JDBCUtil02.getConn();
			
			
			String sql = "select *from usetab where username=? and password=?";
			
			//2.创建ps对象d
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			//3.执行
			 rs = ps.executeQuery();
			
			 //
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil02.release(conn, ps,rs);
		}
		return false;
	}

	@Override
	public void insert(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into usetab values(null,?,?)",
				user.getUserName(),
				user.getPassword()
				);
	}

	public void update(User user) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update usetab set  password=? where userName =?", 
				user.getPassword(),	
				user.getUserName()
				);
	}
}

