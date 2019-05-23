package com.chatter.domain;

import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class ArticleDto {

    private String articleid;
    private String author;
    private String title;
    private String content;
    private Date created;
    private boolean open;

    public String getArticleid() { return articleid; }
    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreated() { return created; }
    public boolean isOpen() { return open; }

    public void setArticleid(String articleid) { this.articleid = articleid; }
    public void setAuthor(String author) { this.author = author; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setCreated(Date created) { this.created = created; }
    public void setOpen(boolean open) { this.open = open; }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "articleid='" + articleid + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", open=" + open +
                '}';
    }
}
