package com.web.addressBook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.domain.addressBook;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//1. ����id
			int userName = Integer.parseInt(request.getParameter("userName"));
			
			//2. ��ѯѧ������
			StudentService service = new StudentServiceImpl();
			addressBook user = service.findStudentById(userName);
			
			//3. ��ʾ����
			//������
			request.setAttribute("user", user);
			//��ת
			request.getRequestDispatcher("edituser.jsp").forward(request, response);
			
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
