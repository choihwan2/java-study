package com.ssafy.day0724;

public class StudentMgr {

	private static StudentMgr mgr = new StudentMgr();

	private StudentMgr() {

	}

	public static StudentMgr getInstacne() {
		return mgr;
	}
}
