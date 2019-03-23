package priv.general.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priv.general.system.bean.base.User;

public class LoginRequiredFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String url = req.getRequestURI();
		
		if(user != null || (user == null && (url.endsWith("login.do") || url.endsWith("login") 
				|| url.endsWith("login.html") || url.endsWith("ssm/indx.html") || url.endsWith("ssm/")))) {
			chain.doFilter(request, response);
		} else {
			//重定向到登陆页面
			res.sendRedirect("/ssm/login.html");
		}
		return;
	}

	@Override
	public void destroy() {
		
	}

}

