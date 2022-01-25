package com.tongyaxi.blog.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0DataBase Pool設置ファイル
 */
public class C3P0Connection {

	private static C3P0Connection instance;

	private static ComboPooledDataSource dataSource;

	private C3P0Connection() throws Exception {
		dataSource = new ComboPooledDataSource();
	}

	/**
	 * インスタンス化
	 * @return
	 */
	public static final C3P0Connection getInstance() {
		if (instance == null) {
			try {
				instance = new C3P0Connection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * データベース接続
	 * @return
	 */
	public synchronized final Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
