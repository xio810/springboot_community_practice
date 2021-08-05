package com.xio.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xio.exam.demo.repository.ArticleRepository;
import com.xio.exam.demo.util.Ut;
import com.xio.exam.demo.vo.Article;
import com.xio.exam.demo.vo.ResultData;

@Service
public class ArticleService {

	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;

	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	//////
	public ResultData writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		
		int id = articleRepository.getLastInsertId();
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 등록", id), id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

}
