package com.mybatis.model;

import java.util.List;

public class CourseMybatis {
	private int cid;
	private String cname;
	private double cfees;
	private List<StudentMybatis> sbt;

	public List<StudentMybatis> getSbt() {
		return sbt;
	}

	public void setSbt(List<StudentMybatis> sbt) {
		this.sbt = sbt;
	}

	public CourseMybatis() {
	}

	public CourseMybatis(int cid, String cname, double cfees) {
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
