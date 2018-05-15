package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class ValidateUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	//通过一个用户名实时验证该用户名是否有创建过
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserDao userDao=new UserDao();
		//获取到用户名
		String uname=request.getParameter("uname");
		boolean f=userDao.selectID(uname);
		if(f){
			out.println("<img src='../img/derr.gif'>");
		}else{
			out.println("<img src='../img/dsucess.gif'>");
		}
		out.flush();
		out.close();
	}

}
