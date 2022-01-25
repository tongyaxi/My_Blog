package com.tongyaxi.blog.dao;

import java.util.List;

import com.tongyaxi.blog.model.Comment;

public interface CommentDao {

	/**
	 * article_idでコメントを取得する
	 * @param article_id
	 * @return
	 */
	List getComment(int article_id);
	
	/**
	 * コメントをstar/dissする
	 * @param id
	 * @param star_or_diss
	 * @return
	 */
	int starOrDissComment(int id, int star_or_diss);
	
	/**
	 * コメントする
	 * @param comment
	 * @return
	 */
	boolean addComment(Comment comment);
	
	/**
	 * コメントを削除する
	 * @param comment_id
	 * @return
	 */
	boolean deleteComment(int comment_id);

}