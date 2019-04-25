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
		System.out.println("����Ҫִ��ģ����ѯ�ˣ��յ���name ="+eName + "==genser=="+eSex);
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * ����Ҫ����һ�£�
		 * 	���ֻ������ ��select * from stu where sname like ? ;
		 * 	���ֻ���Ա� �� select * from stu where gender = ?
		 * 
		 * ����������� select * from stu where sname like ? and gender=?
		 * 
		 * ���������û�оͲ�ѯ���С�
		 * 
		 */
		String sql = "select * from addressbooktab where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//�ж���û�������� ����У�����ƴ��sql�������
		if(!TextUtils.isEmpty(eName)){
			sql = sql + "  and eName like ?";
			list.add("%"+eName+"%");
		}
		
		//�ж���û���Ա��еĻ�������ƴ��sql������档
		if(!TextUtils.isEmpty(eSex)){
			sql = sql + " and eSex = ?";
			list.add(eSex);
		}
		
		
		return runner.query(sql , new BeanListHandler<addressBook>(addressBook.class) ,list.toArray() );
		
	}

	@Override
	public List<addressBook> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//��һ���ʺţ�����һҳ���ض�������¼  �� �ڶ����ʺţ� ����ǰ��Ķ�������¼��
		//5 0 --- ��һҳ (1-1)*5
		//5 5  --- �ڶ�ҳ (2-1)*5
		//5 10  --- ����ҳ
		return runner.query("select * from addressbooktab limit ? offset ?", 
				new BeanListHandler<addressBook>(addressBook.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//���ڴ��� ƽ��ֵ �� �ܵĸ����� 
		Long  result = (Long) runner.query("SELECT COUNT(*) FROM addressbooktab" , new ScalarHandler() );
		return result.intValue();
	}
}
