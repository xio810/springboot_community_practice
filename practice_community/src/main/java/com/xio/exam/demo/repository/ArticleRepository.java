package com.xio.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xio.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	@Insert("insert into article set regDate = now(), updateDate = now(), title = #{title}, body = #{body}")
	public void writeArticle(@Param("title") String title, @Param("body") String body);

	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id);

	@Select("select * from article")
	public List<Article> getArticles();

	@Delete("delete from article where id = #{id}")
	public void delete(int id);
	
	@Update ("update article set title = #{title}, `body` = #{body}, updateDate = now() where id = #{id}")
	public void modify(int id, String title, String body);
	
	@Select("select last_insert_id()")
	public int getLastInsertId();
}
