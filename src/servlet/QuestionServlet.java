package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestioinDao;
import entity.Buser;
import entity.Question;

public class QuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuestionServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	// 通过已登录的用户权限查出相对应的问题
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Buser user = (Buser) session.getAttribute("user");
		if (user != null) {
			List<Question> list = new ArrayList<Question>();
			if (user.getUauthorityid() != 1) {
				// 普通用户权限
				list = QuestioinDao.getquestionbyid(user.getUid());
			} else {
				// 管理员权限
				list = QuestioinDao.getquestionby();
			}
			HttpSession session2 = request.getSession();
			session2.setAttribute("list", list);
			request.getRequestDispatcher("page/index1.jsp").forward(request, response);
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
