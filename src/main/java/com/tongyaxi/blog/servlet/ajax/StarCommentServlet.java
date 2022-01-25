package com.tongyaxi.blog.servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.model.Comment;
import com.tongyaxi.blog.service.CommentService;
import net.sf.json.JSONObject;

@WebServlet("/starComment")
public class StarCommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		JSONObject jsonObject = new JSONObject();
		boolean repeat = false;
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("star_cm" + id)) {
				
				jsonObject.put("msg", "failed");
				repeat = true;
				break;
			}
		}
		if (!repeat) {

			CommentService commentService = CommentService.getInstance();
			;
			int new_star = commentService.starOrDissComment(Integer.parseInt(id), Comment.STAR);
			jsonObject.put("msg", "success");
			jsonObject.put("new_star", new_star);

			Cookie cookie = new Cookie("star_cm" + id, System.currentTimeMillis() + "");
			// 有効期限
			cookie.setMaxAge(15 * 60);

			cookie.setPath("/my_blog");
			response.addCookie(cookie);
		}
		response.getWriter().println(jsonObject);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
