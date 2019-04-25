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
 * �����ѯ���е�ѧ����Ϣ��Ȼ����ֵ�list.jspҳ��
 */
public class StudentListServlet extends HttpServlet {
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.��ѯ�������е�ѧ��
			StudentService service = new StudentServiceImpl();
			List<addressBook> list = service.findAll();
			//2. �����ݴ洢����������
			request.setAttribute("list", list);
			//3.��תҳ��
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
