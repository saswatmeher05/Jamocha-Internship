package com.crud.util;

public enum Subjects {
	java,python,php,html,css,javascript,oracle,dotnet,JAVA,PYTHON,PHP,HTML,CSS,JAVASCRIPT,ORACLE,DOTNET;
	
	public static boolean contains(String s) {
		for(Subjects subs:values()) {
			if(subs.name().equals(s)) {
				return true;
			}
		}
		return false;
	}
}
