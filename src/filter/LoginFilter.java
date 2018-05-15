package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
//登录拦截器
public class LoginFilter extends HttpServlet implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//查看session中是否有user用户
		if (req.getSession().getAttribute("user") == null) {
			res.sendRedirect("../login1.jsp");
		} else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}