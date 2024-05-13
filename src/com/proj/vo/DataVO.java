package com.proj.vo;

import java.sql.Timestamp;

public class DataVO {

	@Override
	public String toString() {
		return "DataVO [id=" + id + ", age=" + age + ", hb=" + hb + ", blood_group=" + blood_group + ", gender="
				+ gender + ", external_id=" + external_id + ", pregnant=" + pregnant + ", comments=" + comments
				+ ", samsung_file_link=" + samsung_file_link + ", redmi_file_link=" + redmi_file_link
				+ ", created_date=" + created_date + ", modified_date=" + modified_date + "]";
	}
	private int id;
	private float age;
	private float hb;
	private String blood_group;
	private int gender;
	private String external_id;
	private int pregnant;
	private String comments;
	private String samsung_file_link;
	private String redmi_file_link;
	private Timestamp created_date;
	private Timestamp modified_date;
	//private String misc;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public float getHb() {
		return hb;
	}
	public void setHb(float hb) {
		this.hb = hb;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getExternal_id() {
		return external_id;
	}
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	public int getPregnant() {
		return pregnant;
	}
	public void setPregnant(int pregnant) {
		this.pregnant = pregnant;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getSamsung_file_link() {
		return samsung_file_link;
	}
	public void setSamsung_file_link(String samsung_file_link) {
		this.samsung_file_link = samsung_file_link;
	}
	public String getRedmi_file_link() {
		return redmi_file_link;
	}
	public void setRedmi_file_link(String redmi_file_link) {
		this.redmi_file_link = redmi_file_link;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public Timestamp getModified_date() {
		return modified_date;
	}
	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}
	
	
}
