package com.xio.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xio.exam.demo.service.MemberService;
import com.xio.exam.demo.util.Ut;
import com.xio.exam.demo.vo.Member;
import com.xio.exam.demo.vo.ResultData;

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
		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId을 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return ResultData.from("F-2", "password을 입력해주세요.");
		}
		if (Ut.empty(name)) {
			return ResultData.from("F-3", "name을 입력해주세요.");
		}
		if (Ut.empty(nickname)) {
			return ResultData.from("F-4", "nickname을 입력해주세요.");
		}
		if (Ut.empty(cellphoneNo)) {
			return ResultData.from("F-5", "cellphoneNo을 입력해주세요.");
		}
		if (Ut.empty(email)) {
			return ResultData.from("F-6", "email을 입력해주세요.");
		}
		
		ResultData joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if (joinRd.isFail()) {
			return joinRd;
		}
		Member member = memberService.getMemberById((int) joinRd.getData1());
		
		return ResultData.newData(joinRd, member);
	}

}
