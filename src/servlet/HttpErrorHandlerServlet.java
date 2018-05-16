package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpErrorHandlerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter(); 
        Integer status_code=(Integer)request.getAttribute("javax.servlet.error.status_code");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>错误页面</TITLE></HEAD>");
        out.println("  <BODY>");
        switch(status_code){
        case 401:
            out.println("<h2>HTTP状态代码: "+status_code+"</h2>");
            out.println("您无权访问该页面.");
            out.println("<p>如有其它问题,请<a href=mailto:zsgzs.com@gmail.com>联系管理员</a>");
            break;
        case 404:
            out.println("<h2>HTTP状态代码: "+status_code+"</h2>");
            out.println("您所访问的页面并不存在,或者已经被移动到其他位置.<p>");
            out.println("如有其它问题,请<a href=mailto:zsgzs.com@gmail.com>联系管理员</a>");
            break;
        case 500:
            out.println("<h2>HTTP状态代码: "+status_code+"</h2>");
            out.println("您所访问的页面并不存在,或者已经被移动到其他位置.<p>");
            out.println("如有其它问题,请<a href=mailto:zsgzs.com@gmail.com>联系管理员</a>");
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