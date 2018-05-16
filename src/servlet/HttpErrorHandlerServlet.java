package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpErrorHandlerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		Integer status_code = (Integer) request.getAttribute("javax.servlet.error.status_code");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>错误页面</TITLE></HEAD>");
		out.println("  <BODY>");
		switch (status_code) {
		case 401:
			out.println("<h2>HTTP状态代码: " + status_code + "</h2>");
			out.println("您无权访问该页面.");
			out.println("<style>body{text-align:center}#msg{background-color:white;border:1px solid #1B76B7;margin:0 auto;width:400px;text-align:left}.msgtitle{padding:3px 3px;color:white;font-weight:700;line-height:21px;height:25px;font-size:12px;border-bottom:1px solid #1B76B7; text-indent:3px; background-color:#1B76B7}#msgbody{font-size:12px;padding:40px 8px 50px;line-height:25px}#msgbottom{text-align:center;height:20px;line-height:20px;font-size:12px;background-color:#1b76b7;color:#FFFFFF}</style><div id='msg'><div class='msgtitle'>【警告】参数错误：</div><div id='msgbody'><b>错误描述</b>："+status_code+"访问被拒绝</div><div id='msgbottom'>远大住工</div></div>");
			break;
		case 404:
			out.println("<style>body{text-align:center}#msg{background-color:white;border:1px solid #1B76B7;margin:0 auto;width:400px;text-align:left}.msgtitle{padding:3px 3px;color:white;font-weight:700;line-height:21px;height:25px;font-size:12px;border-bottom:1px solid #1B76B7; text-indent:3px; background-color:#1B76B7}#msgbody{font-size:12px;padding:40px 8px 50px;line-height:25px}#msgbottom{text-align:center;height:20px;line-height:20px;font-size:12px;background-color:#1b76b7;color:#FFFFFF}</style><div id='msg'><div class='msgtitle'>【警告】参数错误：</div><div id='msgbody'><b>错误描述</b>："+status_code+"找不到该页面</div><div id='msgbottom'>远大住工</div></div>");
			break;
		case 500:
			out.println("<style>body{text-align:center}#msg{background-color:white;border:1px solid #1B76B7;margin:0 auto;width:400px;text-align:left}.msgtitle{padding:3px 3px;color:white;font-weight:700;line-height:21px;height:25px;font-size:12px;border-bottom:1px solid #1B76B7; text-indent:3px; background-color:#1B76B7}#msgbody{font-size:12px;padding:40px 8px 50px;line-height:25px}#msgbottom{text-align:center;height:20px;line-height:20px;font-size:12px;background-color:#1b76b7;color:#FFFFFF}</style><div id='msg'><div class='msgtitle'>【警告】参数错误：</div><div id='msgbody'><b>错误描述</b>："+status_code+"Web 服务器太忙</div><div id='msgbottom'>远大住工</div></div>");
			break;
		default:
			break;
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
    }
}