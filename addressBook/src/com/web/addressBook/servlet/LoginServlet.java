package com.web.addressBook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.service.Userservice;
import com.web.addressBook.service.impl.UserserviceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡ
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println("username"+userName+"---->password"+password);
		
		
		//2.�������ݿ��û�
		Userservice service = new UserserviceImpl();
		boolean isSuccess = service.login(userName, password);
		if(isSuccess) {
			

			//�ض���
			response.sendRedirect("page/index.jsp");
		}else
		{
			
//			response.sendRedirect("login.jsp");
			response.getWriter().write("��¼ʧ��");
			
			
			
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
