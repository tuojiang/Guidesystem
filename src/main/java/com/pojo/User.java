package com.pojo;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
public class User {
	/**
	 * 学号id
	 */
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 用户密码
	 */
	private String passwd;
	/**
	 * 学院
	 */
	private String college;
	/**
	 * 专业
	 */
	private String professional;
	/**
	 * 班级
	 */
	private String classes;
	/**
	 * 社团
	 */
	private String corporation;
	/**
	 * 审核状态 默认为0，审核通过为1
	 */
	private Integer status;
	/**
	 * 用户角色默认为0，普通用户，1：管理员
	 */
	private Integer role;

	public User() {
	}

	public User(Integer id, String name, String passwd, String college, String professional, String classes, String corporation, Integer status, Integer role) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.college = college;
		this.professional = professional;
		this.classes = classes;
		this.corporation = corporation;
		this.status = status;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
