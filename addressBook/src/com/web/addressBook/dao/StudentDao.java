package com.web.addressBook.dao;

import java.sql.SQLException;
import java.util.List;

import com.web.addressBook.domain.addressBook;

public interface StudentDao {
	
	/**
	 * ��ѯ����ѧ��
	 * @return  List<Student>
	 * @throws SQLException 
	 */
	List<addressBook> findAll() throws SQLException  ;	
	
	/**
	 * ���ѧ��
	 * @param student ��Ҫ��ӵ����ݿ��ѧ������
	 * @throws SQLException
	 */
	void insert(addressBook addressbook) throws SQLException ;
	
	/**
	 * ����idɾ��ѧ��
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int eId) throws SQLException ;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student ��Ҫ���µ�ѧ������
	 * @throws SQLException
	 */
	void update (addressBook addressbook )throws SQLException ;
	
	/**
	 * ����ID��ѯ����ѧ������
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	addressBook findStudentById(int eId)  throws SQLException ;
	
	/**
	 * ģ����ѯ�� �����������߸����Ա𣬻������߼��С� 
	 * @param sname
	 * @param sgender
	 * @return ����
	 * @throws SQLException
	 */
	List<addressBook> searchStudent(String eName , String eSex)  throws SQLException ;

	int PAGE_SIZE = 5; //һҳ��ʾ��������¼
	
	/**
	 * ��ѯ��ҳ��ѧ������
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<addressBook> findStudentByPage(int currentPage) throws SQLException ;
	
	/**
	 * ��ѯ�ܵ�ѧ����¼��
	 * @return
	 * @throws SQLException
	 */
	int findCount()throws SQLException ;
}
