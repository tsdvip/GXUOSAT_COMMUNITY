/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.entity
 * User.java
 */
package com.tsdvip.entity;

import java.io.Serializable;


/**
 * 用户
 * @author tanshangdong
 * @since 2017年3月28日 上午11:46:26
 * @version   
 */
public class User implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
	private Integer userId;
	private Integer roleId;
	private String userName;
	private String password;
	private String nickname;
	private String face;
	private String sex;
	private String phone;
	private String email;
	private String address;
	public User() {

	}
	public User(Integer userId, Integer roleId, String userName,
            String password, String nickname, String face, String sex,
            String phone, String email, String address) {
	    super();
	    this.userId = userId;
	    this.roleId = roleId;
	    this.userName = userName;
	    this.password = password;
	    this.nickname = nickname;
	    this.face = face;
	    this.sex = sex;
	    this.phone = phone;
	    this.email = email;
	    this.address = address;
    }
	
    public Integer getUserId() {
    	return userId;
    }
	
    public void setUserId(Integer userId) {
    	this.userId = userId;
    }
	
    public Integer getRoleId() {
    	return roleId;
    }
	
    public void setRoleId(Integer roleId) {
    	this.roleId = roleId;
    }
	
    public String getUserName() {
    	return userName;
    }
	
    public void setUserName(String userName) {
    	this.userName = userName;
    }
	
    public String getPassword() {
    	return password;
    }
	
    public void setPassword(String password) {
    	this.password = password;
    }
	
    public String getNickname() {
    	return nickname;
    }
	
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }
	
    public String getFace() {
    	return face;
    }
	
    public void setFace(String face) {
    	this.face = face;
    }
	
    public String getSex() {
    	return sex;
    }
	
    public void setSex(String sex) {
    	this.sex = sex;
    }
	
    public String getPhone() {
    	return phone;
    }
	
    public void setPhone(String phone) {
    	this.phone = phone;
    }
	
    public String getEmail() {
    	return email;
    }
	
    public void setEmail(String email) {
    	this.email = email;
    }
	
    public String getAddress() {
    	return address;
    }
	
    public void setAddress(String address) {
    	this.address = address;
    }
	
    public static long getSerialversionuid() {
    	return serialVersionUID;
    }
	@Override
    public String toString() {
	    return "User [userId=" + userId + ", roleId=" + roleId + ", userName="
	            + userName + ", password=" + password + ", nickname="
	            + nickname + ", face=" + face + ", sex=" + sex + ", phone="
	            + phone + ", email=" + email + ", address=" + address + "]";
    }
	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((address == null) ? 0 : address.hashCode());
	    result = prime * result + ((email == null) ? 0 : email.hashCode());
	    result = prime * result + ((face == null) ? 0 : face.hashCode());
	    result = prime * result
	            + ((nickname == null) ? 0 : nickname.hashCode());
	    result = prime * result
	            + ((password == null) ? 0 : password.hashCode());
	    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	    result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
	    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
	    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
	    result = prime * result
	            + ((userName == null) ? 0 : userName.hashCode());
	    return result;
    }
	@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    User other = (User) obj;
	    if (address == null) {
		    if (other.address != null)
			    return false;
	    }
	    else if (!address.equals(other.address))
		    return false;
	    if (email == null) {
		    if (other.email != null)
			    return false;
	    }
	    else if (!email.equals(other.email))
		    return false;
	    if (face == null) {
		    if (other.face != null)
			    return false;
	    }
	    else if (!face.equals(other.face))
		    return false;
	    if (nickname == null) {
		    if (other.nickname != null)
			    return false;
	    }
	    else if (!nickname.equals(other.nickname))
		    return false;
	    if (password == null) {
		    if (other.password != null)
			    return false;
	    }
	    else if (!password.equals(other.password))
		    return false;
	    if (phone == null) {
		    if (other.phone != null)
			    return false;
	    }
	    else if (!phone.equals(other.phone))
		    return false;
	    if (roleId == null) {
		    if (other.roleId != null)
			    return false;
	    }
	    else if (!roleId.equals(other.roleId))
		    return false;
	    if (sex == null) {
		    if (other.sex != null)
			    return false;
	    }
	    else if (!sex.equals(other.sex))
		    return false;
	    if (userId == null) {
		    if (other.userId != null)
			    return false;
	    }
	    else if (!userId.equals(other.userId))
		    return false;
	    if (userName == null) {
		    if (other.userName != null)
			    return false;
	    }
	    else if (!userName.equals(other.userName))
		    return false;
	    return true;
    }
	
}
