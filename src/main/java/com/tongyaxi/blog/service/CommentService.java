package com.tongyaxi.blog.service;

import java.util.List;

import com.tongyaxi.blog.dao.CommentDao;
import com.tongyaxi.blog.dao.impl.CommentDaoImpl;
import com.tongyaxi.blog.model.Comment;

public class CommentService {

	private CommentDao dao;

	private static CommentService instance;

	private CommentService() {
		dao = CommentDaoImpl.getInstance();
	}

	public static final CommentService getInstance() {
		if (instance == null) {
			try {
				instance = new CommentService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public List getComment(int article_id) {
		return dao.getComment(article_id);
	}

	public int starOrDissComment(int id, int star_or_diss) {
		return dao.starOrDissComment(id, star_or_diss);
	}
	
	public boolean addComment(Comment comment) {
		return dao.addComment(comment);
	}

	public boolean deleteComment(int id) {
		return dao.deleteComment(id);
	}
}
