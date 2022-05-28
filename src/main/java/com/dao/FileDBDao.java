package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bean.RoleBean;
import com.bean.UserFileBean;

@Repository
public class FileDBDao {

	@Autowired
	JdbcTemplate st;
	
	public void insertUser(UserFileBean bean) {
		st.update("insert into filedb (name,email,password,profileurl) values (?,?,?,?)",bean.getName(),bean.getEmail(),bean.getPassword(),bean.getProfileurl());
	}
	
	public List<UserFileBean> getUser(String email,String password) {
		List<UserFileBean> roles = st.query("select * from filedb where email=? and password=?", new BeanPropertyRowMapper<UserFileBean>(UserFileBean.class),new Object[] {email,password});
		System.out.println(roles);
		return roles;
	}
	
	public List<UserFileBean> updatePic(String str) {
		String[] arrOfStr = str.split("/");
		st.update("update filedb set defaultpic=true where profileurl=? and email=?", str,arrOfStr[0]);
		st.update("update filedb set defaultpic=false where profileurl!=? and email=?", str,arrOfStr[0]);
		List<UserFileBean> roles = st.query("select * from filedb where email=?", new BeanPropertyRowMapper<UserFileBean>(UserFileBean.class),new Object[] {arrOfStr[0]});
		System.out.println(roles);
		return roles;
	}

	
}
