package com.tongyaxi.blog.utils;

import java.util.List;

import com.tongyaxi.blog.model.Article;
import com.tongyaxi.blog.model.TimeLineArticle;

/**
 * 記事ツール
 * 
 */
public class ArticleUtils {

	/**
	 * 記事時間を処理する
	 * @param list
	 * @return
	 */
	public static List cutTime(List<Article> list) {

		for (Article a : list) {
			a.setTime(a.getTime().substring(0, 11));
		}

		return list;
	}

	/**
	 * 記事時間を処理する
	 * @param Article
	 * @return
	 */
	public static Article cutTime(Article a) {
		a.setTime(a.getTime().substring(0, 11));
		return a;
	}

	/**
	 * 記事内容を処理する
	 * @param list
	 * @return
	 */
	public static List cutContent(List<Article> list) {

		for (Article a : list) {
			if (a.getContent() != null && a.getContent().length() > 351) {
				a.setContent(a.getContent().substring(0, 349) + "...");
			}
		}
		return list;
	}

	/**
	 * タイムライン記事を取得する
	 * @param article
	 * @return
	 */
	public static TimeLineArticle getTimeLineArticle(Article article) {

		TimeLineArticle axisArticle = new TimeLineArticle();

		axisArticle.setTitle(article.getTitle());
		axisArticle.setId(article.getId());

		String year = StringUtils.cutString(article.getTime(), 0, 4);
		String month = StringUtils.cutString(article.getTime(), 5, 7);
		String day = StringUtils.cutString(article.getTime(), 8, 10);

		axisArticle.setYear(Integer.valueOf(year));
		axisArticle.setMonth(Integer.valueOf(month));
		axisArticle.setDay(Integer.valueOf(day));

		return axisArticle;
	}
}
