package com.xio.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xio.exam.demo.repository.ArticleRepository;
import com.xio.exam.demo.vo.Article;

@Service
public class ArticleService {

	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
//		makeTestData();
	}

//	private void makeTestData() {
//		for (int i = 1; i <= 5; i++) {
//			String title = "title" + i;
//			String body = "body" + i;
//
//			writeArticle(title, body);
//		}
//
//	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public int writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		return articleRepository.getLastInsertId();
		
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

}
