package priv.general.system.server.base.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import priv.general.system.bean.base.User;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public User selectOne(User u) {
		return sqlSessionTemplate.selectOne("selectOne", u.getUsername());
	}
	
}
