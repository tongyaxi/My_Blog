package com.tongyaxi.blog.dao;

import java.util.List;
import java.util.Map;

import com.tongyaxi.blog.model.Article;

public interface ArticleDao {

	static final String SEARCH_ARTICLE = "article";
	static final String SEARCH_CATEGORY = "category";

	static final int LESS = 1;
	static final int MORE = 2;
	
	/**
	 * 分類を取得する
	 * @param search_column
	 * @return
	 */
	Map getCategoryAndCount(String search_column);
	
	/**
	 * 記事を取得する
	 * @return
	 */
	List getAllArticle();
	
	/**
	 * 記事・分類の数を取得する
	 * @param search_key
	 * @return
	 */
	int getCount(String search_key);
	
	/**
	 * 記事ランクを取得する
	 * @return
	 */
	List getVisitRank();
	
	/**
	 * 全ての分類を取得する
	 * @return
	 */
	List getAllCategory();
	
	/**
	 * カラム名で記事を取得する
	 * @param column
	 * @param value
	 * @return
	 */
	List<Article> getArticleByColumn(String column, String value);

	/**
	 * 前の記事を取得する次の記事を取得する
	 * @param time
	 * @param less_or_more
	 * @return
	 */
	Article getANearArticle(String time, int less_or_more);
	
	/**
	 * いいね！処理
	 * @param id
	 * @return
	 */
	int starArticle(int id);
	
	/**
	 * 記事を新規する
	 * @param a
	 * @return
	 */
	Article addArticle(Article a);
	
	/**
	 * 記事を削除する
	 * @param id
	 * @return
	 */
	boolean deleteArticle(String id);
	
	/**
	 * 訪問数を更新する
	 * @param article_id
	 */
	void addVisit(int article_id);

}