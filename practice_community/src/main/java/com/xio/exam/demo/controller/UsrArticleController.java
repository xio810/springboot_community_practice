package com.xio.exam.demo.controller;

//controller
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xio.exam.demo.service.ArticleService;
import com.xio.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}

		return article;
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		return articleService.writeArticle(title, body);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + " 번 게시물은 존재하지 않습니다 ";
		}
		articleService.delete(id);

		return id + " 번 게시물삭제";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + " 번 게시물은 존재하지 않습니다 ";
		}
		articleService.modify(id, title, body);

		return id + " 번 게시물 수정 ";
	}
}
