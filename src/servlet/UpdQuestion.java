package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.QuestioinDao;
import entity.Buser;
import entity.Question;
import servlet.SubmitQuestion.MyRename;

public class UpdQuestion extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UpdQuestion() {
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
	// 管理员针对普通用户提交的问题提出解决方案
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String path = getServletContext().getRealPath("/up");
		String src = "";
		MultipartRequest multiReq = new MultipartRequest(req, path, 1024 * 1024 * 100, "UTF-8", new MyRename());
		// 获取表单上的上传文件控件并且遍历
		Enumeration fileNames = multiReq.getFileNames();
		while (fileNames.hasMoreElements()) {
			String name = (String) fileNames.nextElement();
			File file = multiReq.getFile(name);
			System.out.println(file);
			if (null != file) {
				String fileName = multiReq.getFilesystemName(name);
				String contentType = multiReq.getContentType(name);
				src = "up/" + fileName;
				
			}
		}
		List<String> list = new ArrayList<String>();
		// 获取表单上的普通控件并且遍历
		Enumeration formValue = multiReq.getParameterNames();
		while (formValue.hasMoreElements()) {
			String param = (String) formValue.nextElement();
			String value = multiReq.getParameter(param);
			list.add(value);
		}
		int questionid = Integer.parseInt(list.get(0));;
		String jieda = list.get(2);
		int jiejue = 0;
		if (list.get(1).equals("1")) {
			jiejue = 1;
		} else {
			jiejue = 0;
		}
		int gongkai = 0;
		if (list.get(3).equals("1")) {
			gongkai = 1;
		} else {
			gongkai = 0;
		}
		Date date = new Date();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
		HttpSession session = req.getSession();
		Buser buser = (Buser) session.getAttribute("user");
		int openOrNo = 0;
		Question question = new Question(questionid, dateStr, jieda, jiejue, gongkai, src);
		// 将修改解答过后的问题提交
		Boolean boolean1 = QuestioinDao.updQuestion(question);
		// 判断修改成功以后
		if (boolean1) {
			if (buser.getUid() != 1) {
				List<Question> list1 = QuestioinDao.getquestionbyid(buser.getUid());
				req.setAttribute("list", list1);
				req.getRequestDispatcher("page/index1.jsp").forward(req, resp);
			} else {
				List<Question> list1 = QuestioinDao.getquestionby();
				;
				req.setAttribute("list", list1);
				req.getRequestDispatcher("page/index1.jsp").forward(req, resp);
			}
		} else {
			if (buser.getUid() != 1) {
				List<Question> list1 = QuestioinDao.getquestionbyid(buser.getUid());
				req.setAttribute("list", list1);
				req.getRequestDispatcher("page/index1.jsp").forward(req, resp);
			} else {
				List<Question> list1 = QuestioinDao.getquestionby();
				;
				req.setAttribute("list", list1);
				req.getRequestDispatcher("page/index1.jsp").forward(req, resp);
			}
		}
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}
	class MyRename implements FileRenamePolicy{
		  
		  @Override
		  public File rename(File file) {
		    String fileName = file.getName();
		    String extName = fileName.substring(fileName.lastIndexOf("."));
		    String uuid = UUID.randomUUID().toString().replace("-","");
		    String newName = uuid+extName;//abc.jpg
		    file = new File(file.getParent(),newName);
		    return file;
		  }
		  
		}

}
