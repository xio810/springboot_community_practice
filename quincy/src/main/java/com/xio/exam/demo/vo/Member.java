package com.xio.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private int authLevel; //관리자인지 일반회원인지 알려주는 
	private String name;
	private String nickname;
	private String cellphoneNo;
	private String email;
	private boolean delStatus; //삭제상태 
	private String delDate; //삭제 날짜 
}
