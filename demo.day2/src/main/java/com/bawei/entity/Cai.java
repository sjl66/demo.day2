package com.bawei.entity;

import java.util.List;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


//菜单实例类
public class Cai {
	private Integer cid;
	@NotBlank(message="不能为空")
	private String name;
	@NotNull(message="不能为0")
	
	private double price;
	private List<Liao> liao;
	private Integer[] lids;
	
	public Cai(Integer cid, String name, double price, List<Liao> liao, Integer[] lids) {
		super();
		this.cid = cid;
		this.name = name;
		this.price = price;
		this.liao = liao;
		this.lids = lids;
	}
	public Integer[] getLids() {
		return lids;
	}
	public void setLids(Integer[] lids) {
		this.lids = lids;
	}
	public Cai(Integer cid, String name, double price, List<Liao> liao) {
		super();
		this.cid = cid;
		this.name = name;
		this.price = price;
		this.liao = liao;
	}
	public Cai() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cai [cid=" + cid + ", name=" + name + ", price=" + price + ", liao=" + liao + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Liao> getLiao() {
		return liao;
	}
	public void setLiao(List<Liao> liao) {
		this.liao = liao;
	}
	
	

}
