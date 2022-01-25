package com.tongyaxi.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.tongyaxi.blog.dao.UserDao;
import com.tongyaxi.blog.db.C3P0Connection;
import com.tongyaxi.blog.model.User;
import com.tongyaxi.blog.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	private Connection conn;

	private UserDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}

	private static UserDao instance;

	public static final UserDao getInstance() {
		if (instance == null) {
			try {
				instance = new UserDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/**
	 * ログイン
	 */
	@Override
	public User login(String username, String password) {

		User user = null;

		String sql = "select * from tb_user where user_name = ? and user_password = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				user = new User();
				map.put("user_name", rs.getString("user_name"));
				map.put("user_password", rs.getString("user_name"));
				map.put("user_id", rs.getString("user_id"));
				try {
					// Map➡Bean
					BeanUtils.populate(user, map);
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
			// データベースをクルーズする
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean register(String username, String password) {
		return false;
	}
}
