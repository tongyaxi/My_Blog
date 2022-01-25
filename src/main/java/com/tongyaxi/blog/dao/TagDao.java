package com.tongyaxi.blog.dao;

import java.util.List;

public interface TagDao {

	int DEFAULT_ID = 0;
	String DEFAULT_TAG = "LEMONREDS2017";
	
	/**
	 * 全てのタグを取得する
	 * @return
	 */
	List getAllTag();
	
	/**
	 * カラム名でタグを取得する
	 * @param column
	 * @param value
	 * @return
	 */
	List getTagByColumn(String column, String value);

	/**
	 * タグを新規する
	 * @param id
	 * @param tag
	 * @return
	 */
	boolean addTag(int id, String tag);

	

}