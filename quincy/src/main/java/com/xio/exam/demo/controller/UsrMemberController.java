package com.xio.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xio.exam.demo.service.MemberService;
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
			return "loginId를 입력해주세요.";
		}
		if (loginPw == null || loginPw.trim().length() == 0) {
			return "loginPw를 입력해주세요.";
		}
		if (name == null || name.trim().length() == 0) {
			return "name를 입력해주세요.";
		}
		if (nickname == null || nickname.trim().length() == 0) {
			return "nickname를 입력해주세요.";
		}
		if (cellphoneNo == null || cellphoneNo.trim().length() == 0) {
			return "전화번호를 입력해주세요.";
		}
		if (email == null || email.trim().length() == 0) {
			return "email를 입력해주세요.";
		}

		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

		if (id == -1) {
			return "해당 로그인 아이디는 이미 사용중 입니다.";
		}

		Member member = memberService.getMemberById(id);

		return member;
	}
}
