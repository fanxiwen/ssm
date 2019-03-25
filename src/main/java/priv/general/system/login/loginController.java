package priv.general.system.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.general.system.bean.base.User;
import priv.general.system.server.base.service.UserService;

@Controller
@RequestMapping("login")
public class loginController {

	@Resource
	public UserService userService;
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		HttpSession session = request.getSession();
		
		String status = userService.login(user);
		if("SUCCESS".equals(status)) {
		    session.setAttribute("user", user);	
		}
		return status;
		
	}
}
