package com.mybatis.model;

public class CourseMybatis {
	private int cid;
	private String cname;
	private double cfees;
	
	public CourseMybatis() {}
	
	public CourseMybatis(int cid, String cname, double cfees) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cfees = cfees;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getCfees() {
		return cfees;
	}
	public void setCfees(double cfees) {
		this.cfees = cfees;
	}
}
