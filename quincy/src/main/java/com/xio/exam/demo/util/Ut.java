package com.xio.exam.demo.util;

public class Ut {
	//로그인 아이디가 비어있는지 확인하는 함수
	public static boolean empty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String == false) {
			return true;
		}
		
		String str = (String) obj;
		
		return str.trim().length() == 0;
	}
	
	public static String f(String format, Object... args) {
		return String.format(format, args);
	}

}
