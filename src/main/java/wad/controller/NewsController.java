
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wad.repository.NewsRepository;


@Controller
public class NewsController {
    
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/news")
    public String listNews(Model model) {
        model.addAttribute("news", this.newsRepository.findAll());
        return "news";
    }
}
