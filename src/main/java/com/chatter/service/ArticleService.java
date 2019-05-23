package com.chatter.service;

import com.chatter.domain.ArticleDto;
import com.chatter.repository.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public void insertArticle(ArticleDto article) {
        try {
            articleMapper.insertArticle(article);
        } catch (Exception e) {
            System.out.println("ArticleService : insertArticle Failed.\n");
            e.getCause();
        }
    }

    public ArrayList<ArticleDto> getArticlesRanged(int start, int num) { return articleMapper.getArticlesRanged(start, num); }

    public ArticleDto getArticleById(int articleid) { return articleMapper.getArticleById(articleid); }

    public ArrayList<ArticleDto> getArticleByAuthor(String author) { return articleMapper.getArticleByAuthor(author); }

    public int countArticles() { return articleMapper.countArticles(); }

    public void editArticleContent(int articleid, String content) { articleMapper.editArticleContent(articleid, content); }

    public void deleteArticle(int articleid) { articleMapper.deleteArticle(articleid); }
}
