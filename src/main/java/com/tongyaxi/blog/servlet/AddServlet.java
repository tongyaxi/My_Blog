package com.tongyaxi.blog.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongyaxi.blog.service.ArticleService;
import com.tongyaxi.blog.service.TagService;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		request.setAttribute("time", df.format(date));
		
		ArticleService as = ArticleService.getInstance();
		Map sort_count = as.getCategoryAndCount();
		request.setAttribute("getAllCategory", sort_count);
		
		TagService tg = TagService.getInstance();

		List all_tag = tg.getAllTag();
		request.setAttribute("getAllTag", all_tag);

		request.getRequestDispatcher("/admin/add.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
