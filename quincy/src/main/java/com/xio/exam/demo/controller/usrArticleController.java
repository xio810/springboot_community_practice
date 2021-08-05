package com.xio.exam.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xio.exam.demo.service.ArticleService;
import com.xio.exam.demo.util.Ut;
import com.xio.exam.demo.vo.Article;
import com.xio.exam.demo.vo.ResultData;

@Controller
public class usrArticleController {
	
	private ArticleService articleService;
	
	public usrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
	////getArticle/////
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		Article article = articleService.getArticle(id);
		
		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 입니다.", id), article);
	}

	////doAdd/////
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData doAdd(String title, String body) {
		if(Ut.empty(title)) {
			return ResultData.from("F-1", "title을 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return ResultData.from("F-2", "body를 입력해주세요.");
		}
		
		ResultData resultDataRd = articleService.writeArticle(title, body);
		int id = (int) resultDataRd.getData1();
		
		Article article = articleService.getArticle(id);
		
		return ResultData.from(resultDataRd.getResultCode(), resultDataRd.getMsg(), article);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 없습니다.";
		}
		articleService.deleteArticle(id);

		return id + "번 게시물을 삭제하였습니다.";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 없습니다.";
		}
		articleService.modifyArticle(id, title, body);

		return id + "번 게시물을 수정하였습니다.";
	}
}
