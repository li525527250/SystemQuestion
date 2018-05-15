package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.Buser;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	//注册用户
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
		UserDao userDao = new UserDao();
		boolean f = userDao.selectID(name);
		String pwd = request.getParameter("passWord");
		String quanxian = request.getParameter("quanxian");
		int quanx = 0;
		// 判断权限
		if (quanxian.equals("guanli")) {
			// 管理员
			quanx = 1;
		} else if (quanxian.equals("putong")) {
			// 普通用户
			quanx = 2;
		}
		String gongshi = request.getParameter("gongshi");
		Buser uBuser = new Buser(name, pwd, quanx, gongshi);
		// 先判断这个用户名是否已经注册
		if (f) {
			request.getRequestDispatcher("page/index1.jsp").forward(request, response);
		} else {
			// 在判断是否选择公司
			if (gongshi.equals("请选择公司")) {
				request.getRequestDispatcher("page/register.jsp").forward(request, response);
			} else {
				// 注册用户成功
				boolean flag = UserDao.registerUser(uBuser);
				if (flag) {
					response.sendRedirect("page/index1.jsp");
				} else {
					response.sendRedirect("page/index1.jsp");
				}
			}
		}
		out.close();
	}
}
