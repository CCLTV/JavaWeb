package com.web.addressBook.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.addressBook.dao.StudentDao;
import com.web.addressBook.dao.impl.StrudentDaoImpl;
import com.web.addressBook.domain.addressBook;
import com.web.addressBook.service.StudentService;
import com.web.addressBook.service.impl.StudentServiceImpl;

/**
 * 负责查询所有的学生信息，然后呈现到list.jsp页面
 */
public class StudentListServlet extends HttpServlet {
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.查询出来所有的学生
			StudentService service = new StudentServiceImpl();
			List<addressBook> list = service.findAll();
			//2. 把数据存储到作用域中
			request.setAttribute("list", list);
			//3.跳转页面
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
