package com.tongyaxi.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.service.TagService;
import com.tongyaxi.blog.utils.StringUtils;

@WebServlet("/tag")
public class TagServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String get = StringUtils.pareCode(request.getParameter("get"));
		
		TagService ts = TagService.getInstance();
		request.setAttribute("getTagAndArticle", ts.getTagAndArticle(get));

		request.getRequestDispatcher("/page/tags.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
