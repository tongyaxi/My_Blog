package com.tongyaxi.blog.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tongyaxi.blog.dao.ArticleDao;
import com.tongyaxi.blog.dao.TagDao;
import com.tongyaxi.blog.dao.impl.ArticleDaoImpl;
import com.tongyaxi.blog.dao.impl.TagDaoImpl;
import com.tongyaxi.blog.db.C3P0Connection;
import com.tongyaxi.blog.model.Article;
import com.tongyaxi.blog.utils.FailException;
import com.tongyaxi.blog.utils.Form2Bean;

public class AdminService {

	private ArticleDao adao;
	private TagDao tdao;
	private static AdminService instance;

	private AdminService() {
		adao = ArticleDaoImpl.getInstance();
		tdao = TagDaoImpl.getInstance();
	}

	public static final AdminService getInstance() {
		if (instance == null) {
			try {
				instance = new AdminService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * 記事を新規する
	 * @param request
	 * @return
	 */
	public Article addArticle(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Article article = null;
		try {
			article = Form2Bean.articleForm2Bean(request);
		} catch (FailException e) {
			e.printStackTrace();
		}
		if (article == null)
			return null;
		Article a = adao.addArticle(article);
		if (a == null)
			return null;
		
		String str = request.getParameter("tags").trim();
		String[] tags = str.split(" ");
		for (String tag : tags) {
			tdao.addTag(a.getId(), tag);
		}
		return a;
	}

	public Article getArticle(String article_id) {
		List<Article> list = adao.getArticleByColumn("id", article_id);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}
	
	public boolean delteArticle(String id) {
		return adao.deleteArticle(id);
	}
	
	public Article updateArticle(HttpServletRequest request) {
		String old_id = request.getParameter("id");

		this.delteArticle(old_id);

		return this.addArticle(request);
	}

}
