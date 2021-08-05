package com.xio.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xio.exam.demo.service.MemberService;
import com.xio.exam.demo.util.Ut;
import com.xio.exam.demo.vo.Member;

@Controller
public class UsrMemberController {

	private MemberService memberService;

	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		if (loginId == null || loginId.trim().length() == 0) {
			return "id입력 ";
		}
		if (Ut.empty(loginPw)) {
			return "pw입력 ";
		}
		if (Ut.empty(name)) {
			return "name입력 ";
		}
		if (Ut.empty(nickname)) {
			return "nickname입력 ";
		}
		if (Ut.empty(cellphoneNo)) {
			return "cellphoneNo입력 ";
		}
		if (Ut.empty(email)) {
			return "email입력 ";
		}
		
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if (id == -1) {
			return "아이디중복 ";
		}
		if(id == -2) {
			return "이름과 이메일 중복";
		}
		Member member = memberService.getMemberById(id);
		
		return member;
	}

}
