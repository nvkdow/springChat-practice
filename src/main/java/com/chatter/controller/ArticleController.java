package com.chatter.controller;

import com.chatter.domain.ArticleDto;
import com.chatter.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/board/write")
    public String showWrite() { return "/board/write"; }

    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String postWrite(ArticleDto article, Principal principal) {
        article.setAuthor(principal.getName());
        articleService.insertArticle(article);

        return "redirect:/board/list/1";
    }
}
