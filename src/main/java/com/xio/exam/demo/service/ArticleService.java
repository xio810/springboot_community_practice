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
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}
	
	public Article writeArticle(String title, String body) {
		return articleRepository.writeArticle(title,body);
	}
	
}
