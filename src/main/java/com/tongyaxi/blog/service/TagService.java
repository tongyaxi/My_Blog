package com.tongyaxi.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.tongyaxi.blog.dao.TagDao;
import com.tongyaxi.blog.dao.impl.TagDaoImpl;
import com.tongyaxi.blog.model.Article;
import com.tongyaxi.blog.model.Tag;
import com.tongyaxi.blog.utils.ArticleUtils;
import com.tongyaxi.blog.utils.StringUtils;

/**
 * タグ
 */
public class TagService {

	private TagDao dao;

	private static TagService instance;

	private TagService() {
		dao = TagDaoImpl.getInstance();
	}

	public static final TagService getInstance() {
		if (instance == null) {
			try {
				instance = new TagService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public List getAllTag() {
		return dao.getAllTag();
	}
	
	public List getTagById(String id) {
		return dao.getTagByColumn("id", id);
	}

	public int getTagCount() {
		return dao.getAllTag().size();
	}
	
	

	/**
	 * タグを取得する、それに関連する記事を取得する
	 * 
	 * @return
	 */
	public Map getTagAndArticle(String tag_name) {

		ArticleService as = ArticleService.getInstance();
		Map map = new HashMap();

		List<Tag> tag_list;
		if (tag_name.equals("all") || StringUtils.isEmpty(tag_name)) {
			tag_list = dao.getAllTag();
		} else {
			tag_list = dao.getTagByColumn("tag", tag_name);
		}


		List<Article> article_list = null;
		for (Tag tag : tag_list) {
			List<Tag> list = dao.getTagByColumn("tag", tag.getTag());
			article_list = new ArrayList();
			for (Tag tag_all : list) {

				List<Article> result = as.getArticle("id", String.valueOf(tag_all.getId()));
				article_list.add(ArticleUtils.cutTime(result.get(0)));
			}
			map.put(tag.getTag(), article_list);
		}
		return map;
	}
}
