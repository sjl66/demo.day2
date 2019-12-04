package com.bawei.entity;
//主料实体类
public class Liao {
	private Integer lid;
	private String name;
	public Liao(Integer lid, String name) {
		super();
		this.lid = lid;
		this.name = name;
	}
	public Liao() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Liao [lid=" + lid + ", name=" + name + "]";
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
