package com.tongyaxi.blog.servlet.ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.service.AdminService;
import com.tongyaxi.blog.service.ArticleService;
import com.tongyaxi.blog.service.TagService;
import com.tongyaxi.blog.utils.StringUtils;

@WebServlet("/adminManagement")
public class AdminManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		AdminService adminService = AdminService.getInstance();

		switch (op) {

		case "edit_article":

			String a_id1 = request.getParameter("article_id");
			request.setAttribute("getArticle", adminService.getArticle(a_id1));

			ArticleService articleService = ArticleService.getInstance();
			Map sort_count = articleService.getCategoryAndCount();
			request.setAttribute("getCategoryAndCount", sort_count);

			TagService tg = TagService.getInstance();
			List all_tag = tg.getAllTag();
			request.setAttribute("getAllTag", all_tag);
			request.getRequestDispatcher("/admin/edit.jsp").forward(request, response);
			break;

		case "delete_article":
			String a_id2 = request.getParameter("article_id");
			adminService.delteArticle(a_id2);
			break;
		default:
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
