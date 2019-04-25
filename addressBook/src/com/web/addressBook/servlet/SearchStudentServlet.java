package com.web.addressBook.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.domain.addressBook;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			//1. 取到了要查询的关键数据 姓名  ， 性别。
			String eName=  request.getParameter("eName");
			String eSex=  request.getParameter("eSex");
			
			//2. 找service去查询
			StudentService service = new StudentServiceImpl();
			List<addressBook> list = service.searchStudent(eName, eSex);
			
			
			System.out.println("list的大小是："+list.size());
			for (addressBook addressbook : list) {
				System.out.println("stu="+addressbook);
			}
			
			request.setAttribute("list", list);
			
			//3. 跳转界面。列表界面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
