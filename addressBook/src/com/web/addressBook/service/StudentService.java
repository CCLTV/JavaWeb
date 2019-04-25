package com.web.addressBook.service;

import java.sql.SQLException;
import java.util.List;

import com.web.addressBook.domain.PageBean;
import com.web.addressBook.domain.addressBook;

public interface StudentService {

	/**
	 * 查询所有学生
	 * @return  List<Student>
	 * @throws SQLException 
	 */
	List<addressBook> findAll() throws SQLException ;	
	/**
	 * 添加学生
	 * @param student 需要添加到数据库的学生对象
	 * @throws SQLException
	 */
	void insert(addressBook addressbook) throws SQLException ;
	
	/**
	 * 根据id删除学生
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int eId) throws SQLException ;
	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update (addressBook addressbook )throws SQLException ;
	
	/**
	 * 根据ID查询单个学生对象
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	addressBook findStudentById(int eId)  throws SQLException ;
	
	/**
	 * 模糊查询， 根据姓名或者根据性别，或者两者兼有。 
	 * @param sname
	 * @param sgender
	 * @return 集合
	 * @throws SQLException
	 */
	List<addressBook> searchStudent(String eName , String eSex)  throws SQLException ;
	
	/**
	 * 查询当页的数据
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException ;
}
