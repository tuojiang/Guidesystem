package com.pojo;

import java.util.Date;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
public class Bbs {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 帖子标题
	 */
	private String title;
	/**
	 * 帖子内容
	 */
	private String content;
	/**
	 * 发帖时间
	 */
	private Date time;
	/**
	 * 发帖人
	 */
	private String author;
	/**
	 * 点赞数
	 */
	private Integer applaud;
	/**
	 * 评论内容
	 */
	private String cmcontent;
	/**
	 * 评论时间
	 */
	private Date cmtime;
	/**
	 * 评论人
	 */
	private String cmauthor;

	public Bbs() {
	}

	public Bbs(String content, String author, String title, Integer id) {
		this.content = content;
		this.author = author;
		this.title = title;
		this.id = id;
	}

	public Bbs(Integer id, String title, String content, Date time, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.author = author;
	}

	public Bbs(String author) {
		this.author = author;
	}

	public Bbs(Integer id, String cmcontent, Date cmtime, String cmauthor) {
		this.id = id;
		this.cmcontent = cmcontent;
		this.cmtime = cmtime;
		this.cmauthor = cmauthor;
	}

	public Bbs(Integer id, String title, String content, Date time, String author, Integer applaud, String cmcontent, Date cmtime, String cmauthor) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.author = author;
		this.applaud = applaud;
		this.cmcontent = cmcontent;
		this.cmtime = cmtime;
		this.cmauthor = cmauthor;
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

	public Integer getApplaud() {
		return applaud;
	}

	public void setApplaud(Integer applaud) {
		this.applaud = applaud;
	}

	public String getCmcontent() {
		return cmcontent;
	}

	public void setCmcontent(String cmcontent) {
		this.cmcontent = cmcontent;
	}

	public Date getCmtime() {
		return cmtime;
	}

	public void setCmtime(Date cmtime) {
		this.cmtime = cmtime;
	}

	public String getCmauthor() {
		return cmauthor;
	}

	public void setCmauthor(String cmauthor) {
		this.cmauthor = cmauthor;
	}
}
