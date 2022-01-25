package com.tongyaxi.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.model.Article;
import com.tongyaxi.blog.service.ArticleService;
import com.tongyaxi.blog.service.CommentService;
import com.tongyaxi.blog.service.TagService;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// IDで記事を取得する
		String id = request.getParameter("id");
		ArticleService articleService = ArticleService.getInstance();

		Article article = articleService.getArticle("id", id).get(0);
		request.setAttribute("article", article);

		// 記事に関連するタグを取得する
		TagService tagService = TagService.getInstance();
		request.setAttribute("getTagsByArticleId", tagService.getTagById(id));
		// 前の記事
		request.setAttribute("getPreviousArticle", articleService.getPreviousArticle(article.getTime()));
		// 次の記事
		request.setAttribute("getNextArticle", articleService.getNextArticle(article.getTime()));
		// 記事のコメントを取得する
		CommentService commentService = CommentService.getInstance();
		request.setAttribute("comment", commentService.getComment(article.getId()));

		request.getRequestDispatcher("/page/article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
