package com.tongyaxi.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.service.ArticleService;
import com.tongyaxi.blog.utils.StringUtils;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 全ての分類を取得するか、一つの分類に紐づける記事を取得するかを判断する
		String get = StringUtils.pareCode(request.getParameter("get"));
		// 初始化分类和和文章
		ArticleService articleService = ArticleService.getInstance();
		request.setAttribute("getCategoryAndAirticle", articleService.getCategoryAndAirticle(get));

		request.getRequestDispatcher("/page/category.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
