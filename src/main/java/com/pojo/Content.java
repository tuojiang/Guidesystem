package com.pojo;

import java.util.Date;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
public class Content {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 配置内容标题
	 */
	private String title;
	/**
	 * 配置内容文本
	 */
	private String content;
	/**
	 * 配置内容时间戳
	 */
	private Date time;
	/**
	 * 配置人
	 */
	private String author;
	/**
	 * 配置内容所属类别
	 */
	private String category;
	/**
	 * 配置内容所属学院
	 */
	private String college;
	/**
	 * 配置内容所属专业
	 */
	private String community;

	public Content(){}

	public Content(Integer id, String title, String content, Date time, String author, String category, String college, String community) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.author = author;
		this.category = category;
		this.college = college;
		this.community = community;
	}

	public Content(Integer id, String title, String content, String author, String category, String college, String community) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.category = category;
		this.college = college;
		this.community = community;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}
}
