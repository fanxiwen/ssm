package priv.general.system.server.base.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import priv.general.system.bean.base.User;
import priv.general.system.server.base.dao.UserDao;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public String login(User u) {
		User user = userDao.selectOne(u);
		return user==null?"FAILED":"SUCCESS";
	}
}
