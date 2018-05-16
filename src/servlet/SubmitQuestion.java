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

public class SubmitQuestion extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SubmitQuestion() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	// 用户通过所提交的条件数据提交一套问题
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String path = getServletContext().getRealPath("/up");
		String pathStr = this.getClass().getClassLoader().getResource("/").getPath();
		// FileRenamePolicy rename = new DefaultFileRenamePolicy();
		String src = "";
		MultipartRequest multiReq = new MultipartRequest(req, path, 1024 * 1024 * 100, "UTF-8", new MyRename());
		// 获取提交上来的控件
		Enumeration fileNames = multiReq.getFileNames();
		// 判断是否是上传文件
		while (fileNames.hasMoreElements()) {
			String name = (String) fileNames.nextElement();
			File file = multiReq.getFile(name);
			if (null != file) {
				String fileName = multiReq.getFilesystemName(name);
				String contentType = multiReq.getContentType(name);
				src = "up/" + fileName;
			}
		}
		List<String> list = new ArrayList<String>();
		// 虎丘表单上的普通控件以及遍历
		Enumeration formValue = multiReq.getParameterNames();
		while (formValue.hasMoreElements()) {
			String param = (String) formValue.nextElement();
			String value = multiReq.getParameter(param);
			list.add(value);
		}
		String jieda = list.get(1);
		int gongkai = 0;
		Date date = new Date();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
		HttpSession session = req.getSession();
		Buser buser = (Buser) session.getAttribute("user");
		if (buser != null) {

			Question question = new Question(jieda, dateStr, buser.getUname(), buser.getUid(), gongkai, src,
					buser.getCompany());
			// 调用问题的添加方法，添加一个问题
			Boolean boolean1 = QuestioinDao.addQuestion(question);
			// 判断是否添加成功
			if (boolean1) {
				// 判断已经登录用户是否为管理员还是为普通用户
				if (buser.getUauthorityid() != 1) {
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
				if (buser.getUauthorityid() != 1) {
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
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	class MyRename implements FileRenamePolicy {

		@Override
		public File rename(File file) {
			String fileName = file.getName();
			String extName = fileName.substring(fileName.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String newName = uuid + extName;// abc.jpg
			file = new File(file.getParent(), newName);
			return file;
		}

	}

}
