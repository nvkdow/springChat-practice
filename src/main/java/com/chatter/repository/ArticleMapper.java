package com.chatter.repository;

import com.chatter.domain.ArticleDto;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO articles(author, title, content) VALUES (#{author}, #{title}, #{content})")
    void insertArticle(ArticleDto article);

    @Select("SELECT * FROM articles ORDER BY articleid desc LIMIT #{start}, #{num}")
    ArrayList<ArticleDto> getArticlesRanged(@Param("start") int start, @Param("num") int num);

    @Select("SELECT * FROM articles WHERE articleid = #{articleid}")
    ArticleDto getArticleById(@Param("articleid") int articleid);

    @Select("SELECT articleid, author, title, content, created FROM articles WHERE author = #{author}")
    ArrayList<ArticleDto> getArticleByAuthor(@Param("author") String author);

    @Select("SELECT count(*) FROM articles")
    int countArticles();

    @Update("UPDATE articles SET content = #{content} WHERE articleid = #{articleid}")
    void editArticleContent(@Param("articleid") int articleid,@Param("content") String content);

    @Delete("DELETE FROM articles WHERE articleid = #{articleid}")
    void deleteArticle(@Param("articleid") int articleid);
}
