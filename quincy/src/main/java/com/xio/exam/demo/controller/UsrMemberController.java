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
	public Member doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

		Member member = memberService.getMemberById(id); //getMemberById => getArticle 과 같은 용도 
		
		return member;
	}
}
