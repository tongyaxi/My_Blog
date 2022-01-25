package com.tongyaxi.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.tongyaxi.blog.dao.ArticleDao;
import com.tongyaxi.blog.dao.impl.ArticleDaoImpl;
import com.tongyaxi.blog.model.Article;
import com.tongyaxi.blog.model.TimeLineArticle;
import com.tongyaxi.blog.utils.ArticleUtils;
import com.tongyaxi.blog.utils.StringUtils;

public class ArticleService {

	private ArticleDao dao;

	private static ArticleService instance;

	private ArticleService() {
		dao = ArticleDaoImpl.getInstance();
	}

	/**
	 * インスタンス化
	 * 
	 * @return
	 */
	public static final ArticleService getInstance() {
		if (instance == null) {
			try {
				instance = new ArticleService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/**
	 * 分類と当該の分類に関る記事数を取得する
	 * 
	 * @return
	 */
	public Map getCategoryAndCount() {
		return dao.getCategoryAndCount(dao.SEARCH_CATEGORY);
	}
	
	/**
	 * 記事を取得する
	 * @return
	 */
	public List getAllArticle() {
		List<Article> list = dao.getAllArticle();
		for (Article a : list) {
			ArticleUtils.cutContent(list);
			ArticleUtils.cutTime(list);
		}
		return list;
	}
	
	/**
	 * タイトルで検索
	 * @return
	 */
	public List getArticleByLikeTitle(String column, String value) {
		
		List<Article> list = dao.getArticleByColumn(column, value);
		for (Article a : list) {
			ArticleUtils.cutContent(list);
			ArticleUtils.cutTime(list);
		}
		return list;
	}
	
	/**
	 * 記事・分類の数を取得する
	 * 
	 * @param search_key
	 * @return
	 */
	public int getCount(String search_key) {
		return dao.getCount(search_key);
	}
	
	/**
	 * 記事ランクを取得する
	 * 
	 */
	public List getVisitRank() {
		
		List list = dao.getVisitRank();
		if (list.size() > 10) {
			for (int i = 10; i < list.size(); i++) {
				list.remove(i);
			}
		}
		for (int y = 0; y < list.size(); y++) {

			Article a = (Article) list.get(y);
			if (a.getTitle().length() > 20) {
				a.setTitle(StringUtils.cutString(a.getTitle(), 0, 19) + "...");
			}
		}

		return list;
	}
	
	/**
	 * 全ての分類を取得するか、一つの分類に紐づける記事を取得するかを判断する
	 * 
	 * @return
	 */
	public Map getCategoryAndAirticle(String category_name) {

		Map map = new HashMap();
		List<Article> articleByCategory = null;

		// 全ての分類を取得する
		if (category_name.equals("all") || StringUtils.isEmpty(category_name)) {
			List<String> categoryList = dao.getAllCategory();

			for (int i = 0; i < categoryList.size(); i++) {
				String category = categoryList.get(i);
				articleByCategory = dao.getArticleByColumn("category", category);
				ArticleUtils.cutTime(articleByCategory);
				map.put(category, articleByCategory);
			}
		} else {
			// 一つの分類に紐づける記事を取得する
			articleByCategory = dao.getArticleByColumn("category", category_name);
			ArticleUtils.cutTime(articleByCategory);
			map.put(category_name, articleByCategory);
		}
		return map;
	}
	
	/**
	 * カラム名で記事を取得する
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Article> getArticle(String column, String value) {
		return dao.getArticleByColumn(column, value);
	}

	/**
	 * 前の記事を取得する
	 * @param time
	 * @return
	 */
	public Article getPreviousArticle(String time) {
		return dao.getANearArticle(time, dao.LESS);
	}

	/**
	 * 次の記事を取得する
	 * @param time
	 * @return
	 */
	public Article getNextArticle(String time) {
		return dao.getANearArticle(time, dao.MORE);
	}
	
	/**
	 * いいね！処理
	 * @param id
	 * @return
	 */
	public int starArticle(int id) {
		return dao.starArticle(id);
	}

	/**
	 * タイムラインの記事を取得する
	 * @return
	 */
	public List getTimeLineList() {
		// 全ての記事を取得する
		List<Article> articles = dao.getAllArticle();
		// タイムライン記事保持用
		List<TimeLineArticle> axis_list = new ArrayList();
		// Article->TimeLineArticle
		for (Article a : articles) {
			TimeLineArticle at = ArticleUtils.getTimeLineArticle(a);
			axis_list.add(at);
		}
		
		TimeLineArticle tmp = null;
		List result = new LinkedList();
		
		if (!axis_list.isEmpty()) {
			tmp = new TimeLineArticle();
			tmp.setId(0);
			tmp.setYear(axis_list.get(0).getYear());
			result.add(tmp);
			result.add(axis_list.get(0));
		}
		
		for (int i = 1; i < axis_list.size(); i++) {
			int present_year = axis_list.get(i).getYear();
			int past_year = axis_list.get(i - 1).getYear();

			if (present_year < past_year) {
				tmp = new TimeLineArticle();
				tmp.setId(0);
				tmp.setYear(present_year);
				result.add(tmp);
			}
			result.add(axis_list.get(i));
		}
		return result;
	}

	public List getAllCategory() {
		return dao.getAllCategory();
	}

	public void addVisit(int article_id) {
		dao.addVisit(article_id);
	}

}