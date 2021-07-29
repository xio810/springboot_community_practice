package com.xio.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xio.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public Article writeArticle(String title, String body);

	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(int id);

	@Select("select * from article")
	public List<Article> getArticles();

	@Delete("delete from article where id = #{id}")
	public void delete(int id);
	@Update ("update article set title = #{title}, `body` = #{body}, updateDate = now() where id = #{id}")
	public void modify(int id, String title, String body);
}
