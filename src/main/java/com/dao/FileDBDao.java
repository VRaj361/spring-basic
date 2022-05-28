package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserFileBean;

@Repository
public class FileDBDao {

	@Autowired
	JdbcTemplate st;
	
	public void insertUser(UserFileBean bean) {
		st.update("insert into filedb (name,email,password,profileurl) values (?,?,?,?)",bean.getName(),bean.getEmail(),bean.getPassword(),bean.getProfileurl());
	}
	
}
