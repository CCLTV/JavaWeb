package com.web.addressBook.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.web.addressBook.dao.StudentDao;
import com.web.addressBook.domain.addressBook;
import com.web.addressBook.util.JDBCUtil02;
import com.web.addressBook.util.TextUtils;

public class StrudentDaoImpl implements StudentDao {

	@Override
	public List<addressBook> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from addressbooktab";
		List<addressBook> list = runner.query(sql, new BeanListHandler<addressBook>(addressBook.class));
		return list;
	}

	@Override
	public void insert(addressBook addressbook) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into addressbooktab values(null,?,?,?,?,?,?,?)",
				addressbook.geteName(),
				addressbook.geteSex(),
				addressbook.geteAge(),
				addressbook.geteTell1(),
				addressbook.geteTell2(),
				addressbook.geteTell3(),
				addressbook.geteAddress()
				);
		
	}
	
	@Override
	public void delete(int eId) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from addressbooktab where eId=?" ,eId);
	}

	@Override
	public void update(addressBook addressbook) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update addressbooktab set eName=? , eSex=? , eAge=? , eTell1=? , eTell2=? , eTell3=? , eAddress=? where eId =?", 
				addressbook.geteName(),
				addressbook.geteSex(),
				addressbook.geteAge(),
				addressbook.geteTell1(),
				addressbook.geteTell2(),
				addressbook.geteTell3(),
				addressbook.geteAddress(),
				addressbook.geteId()
				);
	}


	@Override
	public addressBook findStudentById(int eId) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from addressbooktab where eId = ?", new BeanHandler<addressBook>(addressBook.class) ,eId);
	}

	@Override
	public List<addressBook> searchStudent(String eName, String eSex) throws SQLException {
		System.out.println("现在要执行模糊查询了，收到的name ="+eName + "==genser=="+eSex);
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * 这里要分析一下：
		 * 	如果只有姓名 ，select * from stu where sname like ? ;
		 * 	如果只有性别 ， select * from stu where gender = ?
		 * 
		 * 如果两个都有 select * from stu where sname like ? and gender=?
		 * 
		 * 如果两个都没有就查询所有。
		 * 
		 */
		String sql = "select * from addressbooktab where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//判断有没有姓名， 如果有，就组拼到sql语句里面
		if(!TextUtils.isEmpty(eName)){
			sql = sql + "  and eName like ?";
			list.add("%"+eName+"%");
		}
		
		//判断有没有性别，有的话，就组拼到sql语句里面。
		if(!TextUtils.isEmpty(eSex)){
			sql = sql + " and eSex = ?";
			list.add(eSex);
		}
		
		
		return runner.query(sql , new BeanListHandler<addressBook>(addressBook.class) ,list.toArray() );
		
	}

	@Override
	public List<addressBook> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
		//5 0 --- 第一页 (1-1)*5
		//5 5  --- 第二页 (2-1)*5
		//5 10  --- 第三页
		return runner.query("select * from addressbooktab limit ? offset ?", 
				new BeanListHandler<addressBook>(addressBook.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//用于处理 平均值 、 总的个数。 
		Long  result = (Long) runner.query("SELECT COUNT(*) FROM addressbooktab" , new ScalarHandler() );
		return result.intValue();
	}
}
