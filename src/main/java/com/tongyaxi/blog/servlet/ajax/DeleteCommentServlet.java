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

@WebServlet("/deleteComment")
public class DeleteCommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		JSONObject jsonObject = new JSONObject();
		CommentService commentService = CommentService.getInstance();
		boolean b = commentService.deleteComment(Integer.parseInt(id));
		if (b) {
			jsonObject.put("msg", "success");
		} else {
			jsonObject.put("msg", "fail");
		}
		response.getWriter().println(jsonObject);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
