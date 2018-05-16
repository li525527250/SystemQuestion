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

public class BanswerOrNoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BanswerOrNoServlet() {
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
	// 通过下拉列表查询出问题是否解决
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<Question> list = new ArrayList<Question>();
		String aString = request.getParameter("jiejue");
		HttpSession session = request.getSession();
		Buser uBuser = (Buser) session.getAttribute("user");
		if (uBuser != null) {
			// 通过已经登录的用户的权限进行查询问题
			if (uBuser.getUauthorityid() == 1) {
				// 管理员查询出来的问题
				String a = request.getParameter("jiejue");
				if (a.equals("11")) {
					list = QuestioinDao.getquestionbyanswerId1(1, 1);
				} else {
					list = QuestioinDao.getquestionbyanswerId1(0, 1);
				}
			} else {
				// 普通用户查询出来的问题
				String b = request.getParameter("jiejue");
				if (b.equals("11")) {
					list = QuestioinDao.getquestionbyanswerId2(1, uBuser.getUid());
				} else {
					list = QuestioinDao.getquestionbyanswerId2(0, uBuser.getUid());
				}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
