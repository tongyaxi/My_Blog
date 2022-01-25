package com.tongyaxi.blog.model;

import com.tongyaxi.blog.utils.StringUtils;

/**
 * タイムライン
 */
public class TimeLineArticle {

	private String title;
	private int id;
	private int year;
	private int month;
	private int day;

	@Override
	public String toString() {
		return "TimeLineArticle [title=" + title + ", id=" + id + ", year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
