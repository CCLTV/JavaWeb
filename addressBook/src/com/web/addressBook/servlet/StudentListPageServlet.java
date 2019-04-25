package com.web.addressBook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.domain.PageBean;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListPageServlet
 */
public class StudentListPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//1. ��ȡ��Ҫ��ʾ��ҳ����
			int currentPage =Integer.parseInt( request.getParameter("currentPage"));
			
			//2. ����ָ����ҳ����ȥ��ȡ��ҳ�����ݻ���
			//List<Student> --- list.jsp
			
			StudentService service = new StudentServiceImpl();
			PageBean pageBean= service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			//3. ��ת���档
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
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
