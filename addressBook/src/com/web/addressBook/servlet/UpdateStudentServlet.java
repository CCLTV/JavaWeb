package com.web.addressBook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.web.addressBook.domain.addressBook;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			//1. 获取客户端提交上来的数据
			int eId = Integer.parseInt(request.getParameter("eId"));
			String eName = request.getParameter("eName"); //sname:zhangsan
			String eSex = request.getParameter("eSex");
			String eAge = request.getParameter("eAge");
			String eTell1 = request.getParameter("eTell1"); // 1989-10-18
			String eTell2 = request.getParameter("eTell2");
			String eTell3 = request.getParameter("eTell3");
			String eAddress = request.getParameter("eAddress");
		
			//2. 添加到数据库
			addressBook addressbook = new addressBook(eId, eName, eSex, eAge, eTell1, eTell2, eTell3, eAddress);
			
			//2. 更新数据库数据
			StudentService service = new StudentServiceImpl();
			service.update(addressbook);
			
			//3. 跳转界面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
