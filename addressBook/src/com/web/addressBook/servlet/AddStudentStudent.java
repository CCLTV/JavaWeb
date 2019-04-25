package com.web.addressBook.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.web.addressBook.domain.addressBook;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.impl.StudentServiceImpl;

/**
 * ����ѧ�������
 */
public class AddStudentStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		
		try {
			//1. ��ȡ�ͻ����ύ����������
			String eName= request.getParameter("eName"); //sname:zhangsan
			String eSex = request.getParameter("eSex");
			String eAge = request.getParameter("eAge");
			String eTell1 = request.getParameter("eTell1"); // 1989-10-18
			String eTell2 = request.getParameter("eTell2");
			String eTell3 = request.getParameter("eTell3");
			String eAddress = request.getParameter("eAddress");
		
			//2.��ӵ����ݿ�
			addressBook addressbook = new addressBook(eName, eSex, eAge, eTell1, eTell2, eTell3, eAddress);
		
			StudentService service = new StudentServiceImpl();
			service.insert(addressbook);
		
			//3.��תҳ��
			//
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
