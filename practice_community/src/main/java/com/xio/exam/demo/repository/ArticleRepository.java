package com.xio.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xio.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public void writeArticle(@Param("title") String title, @Param("body") String body);

	public Article getArticle(@Param("id") int id);

	public List<Article> getArticles();

	public void delete(int id);
	
	public void modify(int id, String title, String body);
	
	public int getLastInsertId();
}
