package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class RoleDao {
	@Autowired
	JdbcTemplate st;// this is provide statement

	public void insertRole(RoleBean bean) {
		st.update("insert into role (rolename) values (?)", bean.getRolename());
	}

	public List<RoleBean> getAllRole() {
		List<RoleBean> roles = st.query("select * from role order by roleid desc", new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		return roles;
	}

	public void deleterole(Integer id) {
		st.update("delete from role where roleid=?", id);
	}

	public void updateRole(RoleBean bean) {
		System.out.println("role name "+bean.getRolename()+"  roleid  "+bean.getRoleid());
		st.update("update role set rolename = ? where roleid = ?", bean.getRolename(), bean.getRoleid());
	}

	public List<RoleBean> searchRole(String search) {
		List<RoleBean> roles = st.query("select * from role where rolename like ?",
				new BeanPropertyRowMapper<>(RoleBean.class), new Object[] {search+"%"});
		return roles;
	}

	public RoleBean getRoleByRoleid(int roleid) {
		try {
			RoleBean role = st.queryForObject("select * from role where roleid=?",
					new BeanPropertyRowMapper<>(RoleBean.class), new Object[] { roleid });
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
