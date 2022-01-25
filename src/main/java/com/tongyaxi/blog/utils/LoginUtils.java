package com.tongyaxi.blog.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tongyaxi.blog.dao.UserDao;
import com.tongyaxi.blog.dao.impl.UserDaoImpl;
import com.tongyaxi.blog.model.User;

public class LoginUtils {

	private final static String ErrorMessage = "ユーザー名またはパスワードを正しく入力してください。";
	
	public static boolean login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			request.setAttribute("errorMessage", ErrorMessage);
			return false;
		}

		UserDao dao = UserDaoImpl.getInstance();
		User user = dao.login(username, password);
		if (user == null) {
			request.setAttribute("errorMessage", ErrorMessage);
			return false;
		}

		// sessionに保持する
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return true;

	}

}
