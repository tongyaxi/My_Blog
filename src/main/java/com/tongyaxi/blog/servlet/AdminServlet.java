package com.tongyaxi.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tongyaxi.blog.service.ArticleService;
import com.tongyaxi.blog.service.TagService;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleService articleService = ArticleService.getInstance();
		request.setAttribute("articles", articleService.getAllArticle());
		request.setAttribute("category", articleService.getAllCategory());
		TagService ts = TagService.getInstance();
		request.setAttribute("tags", ts.getAllTag());

		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
