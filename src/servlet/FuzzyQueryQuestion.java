package servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import servlet.SubmitQuestion.MyRename;
import dao.QuestioinDao;
import entity.Buser;
import entity.Question;

/**
 * Servlet implementation class FuzzyQueryQuestion
 */
public class FuzzyQueryQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuzzyQueryQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 根据条件来实现模糊查询问题
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String neiron = request.getParameter("neiron");
		neiron = new String(neiron.getBytes("ISO-8859-1"), "UTF-8");
		String kaishi = request.getParameter("dd");
		String jiesu = request.getParameter("ds");
		String tiwenren = request.getParameter("tiwenren");
		String jiejue = request.getParameter("jiejue");
		jiejue = new String(jiejue.getBytes("ISO-8859-1"), "UTF-8");
		HttpSession session = request.getSession();
		Buser buser = (Buser) session.getAttribute("user");
		if (buser != null) {
			tiwenren = new String(tiwenren.getBytes("ISO-8859-1"), "UTF-8");
			// 根据输入条件拼接sql语句
			String sql = "select * from question";
			sql = sql + " where Bdescribe like '%" + neiron + "%'";
			// 将拿到的时间分割从新拼接作为时间查询的条件
			if (!kaishi.equals("") && !jiesu.equals("")) {
				String[] sourceStrArray = kaishi.split("/");
				String[] sourceStrArray1 = jiesu.split("/");
				String kais = "";
				String jies = "";
				kais = kais + sourceStrArray[2] + "-" + sourceStrArray[0] + "-" + sourceStrArray[1];
				jies = jies + sourceStrArray1[2] + "-" + sourceStrArray1[0] + "-" + sourceStrArray1[1];
				sql = sql + " and Bdate>='" + kais + "' and Bdate<='" + jies + "'";
			}
			// 判断登录权限查询的问题不一样
			if (buser.getUauthorityid() != 1) {
				sql = sql + " and BquestionUname like '%" + tiwenren + "%' and BquestionUid=" + buser.getUid();
			} else {
				sql = sql + " and BquestionUname like '%" + tiwenren + "%'";
			}
			// 判断问题是否已经解决
			if (jiejue.equals("请选择")) {
				sql = sql + " ORDER BY Bquestionid DESC";
			} else if (jiejue.equals("已解决")) {
				sql = sql + " and BanswerOrNo=1 " + " ORDER BY Bquestionid DESC";
			} else {
				sql = sql + " and BanswerOrNo=0 " + " ORDER BY Bquestionid DESC";
			}
			java.util.List<Question> list = new ArrayList<Question>();
			list = QuestioinDao.selectQuestionBySynthesize(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("page/index1.jsp").forward(request, response);
		}
		out.flush();
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
