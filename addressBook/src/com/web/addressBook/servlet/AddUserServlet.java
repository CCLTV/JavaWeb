package com.web.addressBook.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.domain.User;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.Userservice;
import com.web.addressBook.service.impl.StudentServiceImpl;
import com.web.addressBook.service.impl.UserserviceImpl;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		
		try {
			//1. 获取客户端提交上来的数据
			String userName = request.getParameter("userName"); //sname:zhangsan
			
			String password = request.getParameter("password");
			String rpass = request.getParameter("rpass");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			String telnum = request.getParameter("telnum");
			if(userName==""||password==""||rpass==""||age==""||sex==""||telnum=="")
			{ response.sendRedirect("adduser.jsp");
				return;
			}
			//2.添加到数据库
			
			User user = new User(userName, password);
		
		//	StudentService service = new StudentServiceImpl();
			//service.insert(student);
			Userservice service = new UserserviceImpl();
			service.insert(user);
		
			//3.跳转页面
			
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			
			response.sendRedirect("login.jsp");
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
