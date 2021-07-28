package com.xio.exam.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xio.exam.demo.vo.Article;

@Component
public class ArticleRepository {

	private List<Article> articles;
//	private Article article1 = new Article(1, "title1", "body1");
//	private Article article2 = new Article(2, "title2", "body2");
//	private Article article3 = new Article(3, "title3", "body3");
	private int lastId;

	public ArticleRepository() {
		lastId = 0;
		articles = new ArrayList<>();
//		articles.add(article1);
//		articles.add(article2);
//		articles.add(article3);
	}

	public List<Article> getArticles() {
		return articles;
	}

	public Article getArticle(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public Article writeArticle(String title, String body) {
		int id = lastId + 1;

		Article article = new Article(id, title, body);
		articles.add(article);
		lastId = id;

		return article;
	}

	public void delete(int id) {
		Article article = getArticle(id);

		articles.remove(article);
	}

	public void modify(int id, String title, String body) {
		Article article = getArticle(id);

		article.setTitle(title);
		article.setBody(body);
	}

	public void testData() {
		for (int i = 1; i < 6; i++) {
			String title = "title" + i;
			String body = "body" + i;

			writeArticle(title, body);
		}
	}

}
