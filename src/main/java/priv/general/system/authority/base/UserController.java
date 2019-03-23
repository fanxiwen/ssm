package priv.general.system.authority.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.general.system.bean.base.User;
import priv.general.system.server.base.service.UserService;
import priv.general.utils.log.Logger;

@Controller
@RequestMapping("user")
public class UserController extends Logger{

	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return userService.login(user);
	}
	
}
