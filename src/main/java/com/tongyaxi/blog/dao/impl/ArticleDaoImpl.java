package com.tongyaxi.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tongyaxi.blog.dao.ArticleDao;
import com.tongyaxi.blog.db.C3P0Connection;
import com.tongyaxi.blog.model.Article;
import com.tongyaxi.blog.utils.DBUtils;

/*
 * 記事
 *
 */
public class ArticleDaoImpl implements ArticleDao {

	private Connection conn;
	private static ArticleDao instance;

	private ArticleDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}

	public static final ArticleDao getInstance() {
		if (instance == null) {
			try {
				instance = new ArticleDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;

	}
	
	@Override
	public Map getCategoryAndCount(String search_category) {

		String sql = " select " + search_category + " ,count(" + search_category + ") as counts  from tb_article  group by "
				+ search_category;
		Map map = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			map = new HashMap();
			while (rs.next()) {
				map.put(rs.getString(search_category), rs.getInt("counts"));
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public List getAllArticle() {
		
		List<Article> list = new ArrayList();

		String sql = "select * from tb_article";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("category"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				
				list.add(article);
			}
			
			DBUtils.Close(ps, rs);
			
			Collections.sort(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int getCount(String search_key) {

		String sql;
		if (search_key.equals(SEARCH_ARTICLE)) {
			// 記事の数
			sql = "SELECT COUNT(id) FROM tb_article";
		} else {
			// 分類の数
			sql = "SELECT COUNT(DISTINCT(category)) FROM tb_article";
		}
		int result = 0;
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List getVisitRank() {
		
		List<Article> list = new ArrayList();

		String sql = "SELECT * FROM tb_article ORDER BY visit DESC";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("category"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}

			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List getAllCategory() {

		String sql = " select distinct(category) from tb_article order by category";
		List list = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Article> getArticleByColumn(String column, String value) {
		List<Article> list = null;
		Article at = null;
		String sql = "";
		// タイトルで検索
		if("title".equals(column)) {
			sql = "select * from tb_article where title like CONCAT('%'," + "'" + value + "'" + ",'%')";
		}else {
			sql = "select * from tb_article where " + column + " = ?";
		}
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if(!"title".equals(column)) {
				ps.setString(1, value);
			}
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				at = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("category"),
						rs.getString("time"), rs.getInt("star"), rs.getInt("comment"), rs.getInt("visit"),
						rs.getString("content"));
				list.add(at);
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Article getANearArticle(String time, int less_or_more) {

		Article article = null;
		String sql = null;
		if (less_or_more == this.LESS) {
			sql = " SELECT  * FROM tb_article WHERE TIME< '" + time + "'  ORDER BY TIME DESC ";
		} else if (less_or_more == this.MORE) {
			sql = " SELECT  * FROM tb_article WHERE TIME > '" + time + "'  ORDER BY TIME ";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("category"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	@Override
	public int starArticle(int id) {

		String sql = "update tb_article set star = star+1 where id=" + id;
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "select star from tb_article where id=" + id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addVisit(int article_id) {

		String sql = "update tb_article set visit = visit+1 where id = " + article_id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article addArticle(Article a) {

		String sql = "insert into tb_article values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getTitle());
			ps.setString(2, a.getAuthor());
			ps.setString(3, a.getCategory());
			ps.setString(4, a.getTime());
			ps.setInt(5, a.getStar());
			ps.setInt(6, a.getComment());
			ps.setInt(7, a.getVisit());
			ps.setString(8, a.getContent());
			result = ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.getLastArticle();

	}
	
	@Override
	public boolean deleteArticle(String id) {

		String sql = "delete from tb_article where id=?";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result != 0;
	}

	/**
	 * 最新の記事を取得する
	 * @return
	 */
	private Article getLastArticle() {

		String sql = "SELECT * FROM tb_article ORDER BY TIME DESC LIMIT 1";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("category"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				DBUtils.Close(ps, rs);
				return article;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

}