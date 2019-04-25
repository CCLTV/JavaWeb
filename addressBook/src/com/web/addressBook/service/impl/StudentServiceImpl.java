package com.web.addressBook.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.web.addressBook.dao.StudentDao;
import com.web.addressBook.dao.impl.StrudentDaoImpl;
import com.web.addressBook.domain.addressBook;
import com.web.addressBook.domain.PageBean;
import com.web.addressBook.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<addressBook> findAll() throws SQLException {
		StudentDao dao = new StrudentDaoImpl();
		
		return dao.findAll();
	}

	@Override
	public void insert(addressBook addressbook) throws SQLException {
		StudentDao dao = new StrudentDaoImpl();
		 dao.insert(addressbook);
	}

	@Override
	public void delete(int eId) throws SQLException {
		StudentDao dao = new StrudentDaoImpl();
		dao.delete(eId);
	}

	@Override
	public void update(addressBook addressbook) throws SQLException {
		StudentDao dao = new StrudentDaoImpl();
		dao.update(addressbook);
		
	}

	@Override
	public addressBook findStudentById(int eId) throws SQLException {
		StudentDao dao = new StrudentDaoImpl();
		return dao.findStudentById(eId);
	}

	@Override
	public List<addressBook> searchStudent(String eName, String eSex) throws SQLException {
		return new StrudentDaoImpl().searchStudent(eName, eSex);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		
		//封装分页的该页数据
		PageBean<addressBook> pageBean = new PageBean<addressBook>();
		
		int pageSize = StudentDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //设置当前页
		pageBean.setPageSize(pageSize); //设置每页显示多少记录
		
		StudentDao dao = new StrudentDaoImpl() ;
		List<addressBook> list =dao .findStudentByPage(currentPage);
		pageBean.setList(list); //设置这一页的学生数据
		
		//总的记录数， 总的页数。
		int count = dao.findCount();
		pageBean.setTotalSize(count); //设置总的记录数
		//200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return pageBean;
	}
}
