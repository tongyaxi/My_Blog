package com.tongyaxi.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tongyaxi.blog.dao.ArticleDao;
import com.tongyaxi.blog.dao.TagDao;
import com.tongyaxi.blog.db.C3P0Connection;
import com.tongyaxi.blog.model.Tag;
import com.tongyaxi.blog.utils.DBUtils;

/**
 * タグ
 */
public class TagDaoImpl implements TagDao {

	private Connection conn;

	private static TagDao instance;

	private TagDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}

	public static final TagDao getInstance() {
		if (instance == null) {
			try {
				instance = new TagDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	@Override
	public List getAllTag() {

		String sql = "SELECT  distinct(tag)  FROM tb_tag";
		List<Tag> list = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList();
			Tag tag;
			while (rs.next()) {
				tag = new Tag();
				tag.setId(0);
				tag.setTag(rs.getString(1));
				list.add(tag);
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List getTagByColumn(String column, String value) {

		String sql = "select * from tb_tag where " + column + "=?";
		List list = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList();
			Tag tag;
			while (rs.next()) {
				tag = new Tag();
				tag.setId(rs.getInt("id"));
				tag.setTag(rs.getString("tag"));
				list.add(tag);
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addTag(int id, String tag) {

		String sql = "insert into tb_tag values(?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, tag);
			result = ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result != 0;
	}
}
