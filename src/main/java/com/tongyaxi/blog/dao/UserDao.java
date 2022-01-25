package com.tongyaxi.blog.dao;

import com.tongyaxi.blog.model.User;

public interface UserDao {

	/**
	 * ユーザーを新規する
	 * @param username
	 * @param password
	 * @return
	 */
	boolean register(String username, String password);

	/**
	 * 登録機能
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

}