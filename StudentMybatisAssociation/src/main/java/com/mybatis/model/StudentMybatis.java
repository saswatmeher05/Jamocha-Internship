package com.mybatis.model;

public class StudentMybatis {
	private int sid;
	private String sname;
	private int sage;
	private int cid;
	private CourseMybatis cb;

	public CourseMybatis getCb() {
		return cb;
	}

	public void setCb(CourseMybatis cb) {
		this.cb = cb;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public StudentMybatis() {
	}

	public StudentMybatis(String sname, int age, int cid) {
		this.sname = sname;
		this.sage = age;
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "StudentDetails: [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", cid=" + cid + "]";
	}

}
