package com.jarvis1.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="login")
public class loginVo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String lid;
	@Column(name="uname1")
	private String uname1;
	@Column(name="pwd1")
	private String pwd1;
	
	public String getId() {
		return lid;
	}
	public void setId(String id) {
		this.lid = id;
	}
	public String getUname1() {
		return uname1;
	}
	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	
}
