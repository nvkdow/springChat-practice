package com.chatter.controller;

import com.chatter.domain.ArticleDto;
import com.chatter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@Controller
public class BoardController {

    private final int listNum = 10;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/board/list")
    public String board(ModelMap modelMap) {
        ArrayList<ArticleDto> articleList = articleService.getArticlesRanged(0, listNum);
        modelMap.addAttribute("articleList", articleList);
        modelMap.addAttribute("articleNum", articleService.countArticles() / listNum);

        return "/board/list";
    }

    @RequestMapping(value = "/board/list/{page}", method = RequestMethod.GET)
    public String boardList(@PathVariable int page, ModelMap modelMap) {
        ArrayList<ArticleDto> articleList = articleService.getArticlesRanged((page - 1) * listNum, listNum);
        modelMap.addAttribute("articleList", articleList);
        modelMap.addAttribute("articleNum", articleService.countArticles() / listNum);

        return "/board/list";
    }
}
