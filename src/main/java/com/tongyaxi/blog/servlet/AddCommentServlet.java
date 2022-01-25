package com.tongyaxi.blog.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.model.Comment;
import com.tongyaxi.blog.service.CommentService;
import com.tongyaxi.blog.utils.DateUtils;
import com.tongyaxi.blog.utils.FailException;
import com.tongyaxi.blog.utils.Form2Bean;

/**
 * コメントする
 */
@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cookie_name = "comment_cookie" + request.getParameter("id");

		boolean isRpeat = false;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookie_name)) {
					isRpeat = true;
					break;
				}
			}
		}

		String info;
		if (!isRpeat) {
			Comment cm;
			try {
				cm = Form2Bean.commentForm2Bean(request);
				CommentService commentService = CommentService.getInstance();
				boolean result = commentService.addComment(cm);
				if (!result) {
					info = "コメントに失敗しました。";
				} else {
					info = "コメントしました。";
				}
			} catch (FailException e) {
				e.printStackTrace();
				info = "コメントに失敗しました。";
			}
		} else {
			info = "重複にコメントしました。";
		}

		String time = URLEncoder.encode(DateUtils.getFormatDate(new Date()),"utf-8");
		Cookie c = new Cookie(cookie_name, time);
		c.setMaxAge(60 * 60);
		c.setPath("/my_blog");
		response.addCookie(c);

		request.setAttribute("info", info);
		request.getRequestDispatcher("/article").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
