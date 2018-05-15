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

public class UserServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	// 通过用户名和用户密码查询登录
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDao();
		String name = request.getParameter("userName");
		String password = request.getParameter("passWord");
		Buser user = userDao.selectuser(name, password);
		if (user != null) {
			if (user.getUid() == 0) {
				// 5月14修改用户名登录验证
				out.println("<script>alert('用户名或密码错误');location.href='login1.jsp'</script>");
			} else {
				// request.setAttribute("loginStart", '0');
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				// 查询成功跳转至查询问题界面
				request.getRequestDispatcher("Selectquestion2").forward(request, response);
			}
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stube
		doGet(request, response);
	}

}
