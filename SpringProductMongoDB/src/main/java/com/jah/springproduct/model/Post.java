/**
 * from YouTube: https://www.youtube.com/watch?v=Jl9OKQ92SJU
 */
package com.jah.springproduct.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Document(collection = "JobPost")
public class Post {
	
	private String profile;
	private String desc;
	private int exp;
	private String[] techs;
	private String id;
	
	
	public Post() {
//		profile = "";
//		desc = "";
//		exp = 0;
//		techs = new String[5];
	}
	
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String[] getTechs() {
		return techs;
	}
	public void setTechs(String[] techs) {
		this.techs = techs;
	}
		
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Post [profile=" + profile + ", desc=" + desc + ", exp=" + exp + ", techs=" + Arrays.toString(techs)
				+ ", id=" + id + "]";
	}
	
	
}
