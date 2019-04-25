package com.web.addressBook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.domain.User;
import com.web.addressBook.service.Userservice;
import com.web.addressBook.service.impl.UserserviceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//1. 获取客户端提交上来的数据
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
		
			//2. 添加到数据库
			User user = new User(userName,password); 
			
			//2. 更新数据库数据
			Userservice service = new UserserviceImpl();
			service.update(user);
			
			//3. 跳转界面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
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
