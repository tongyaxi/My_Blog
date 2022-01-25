package com.tongyaxi.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tongyaxi.blog.dao.ArticleDao;
import com.tongyaxi.blog.service.ArticleService;
import com.tongyaxi.blog.service.TagService;
import com.tongyaxi.blog.utils.LoginUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String isLogin = request.getParameter("login");
		if("isLogin".equals(isLogin)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		init(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!LoginUtils.login(request)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		init(request, response);
	}
	
	private static void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 分類を初期化する
		ArticleService articleService = ArticleService.getInstance();
		request.setAttribute("getCategoryAndCount", articleService.getCategoryAndCount());
		
		// 記事を初期化する
		request.setAttribute("getAllArticle", articleService.getAllArticle());
		
		// タグを初期化する
		TagService tagService = TagService.getInstance();
		request.setAttribute("getAllTag", tagService.getAllTag());

		// 記事・分類・タグを初期化する
		request.setAttribute("getArticleCount", articleService.getCount(ArticleDao.SEARCH_ARTICLE));
		request.setAttribute("getCategoryCount", articleService.getCount(ArticleDao.SEARCH_CATEGORY));
		request.setAttribute("getTagCount", tagService.getTagCount());

		// 記事ランクを取得する
		request.setAttribute("getVisitRank", articleService.getVisitRank());
		request.getRequestDispatcher("/page/homepage.jsp").forward(request, response);
	}

}
