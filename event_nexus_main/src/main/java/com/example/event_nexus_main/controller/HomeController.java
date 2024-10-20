package com.example.event_nexus_main.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import com.example.event_nexus_main.ArticleRepository.ArticleRepository;
import com.example.event_nexus_main.model.Article;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

	@Controller
	public class HomeController {
		@Autowired
	    private ArticleRepository articleRepository;

	    // Home page mapping
	    @GetMapping("/")
	    public String homePage(Model model) {
	    	 List<Article> latestArticles = articleRepository.findTop2ByOrderByCreatedAtDesc();
	         
	         // Add articles to the model to display in the view
	         model.addAttribute("articles", latestArticles);
	         return "index";  // Return the home.html view
	     }

	    @GetMapping("/login")
	    public String showLoginPage() {
	        return "login";
	    }
	}

