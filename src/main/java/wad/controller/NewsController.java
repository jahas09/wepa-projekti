
package wad.controller;

import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.News;
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
    
    @PostMapping("/news")
    public String postNews(@Valid @ModelAttribute News news, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "luoUutinen";
        }
        news.setTime(new Date());
        this.newsRepository.save(news);
        return "redirect:/news";
    }
    
    @GetMapping("/news/{id}")
    public String getNews(Model model, @PathVariable Long id) {
        Optional<News> uutinen = this.newsRepository.findById(id);
        if(!uutinen.isPresent()){
            return "redirect:/news";
        }
        model.addAttribute("uutinen", uutinen.get());
        return "uutinen";
    }
    
    @GetMapping("/sendNews")
    public String SendNews(@ModelAttribute News news) {
        return "luoUutinen";
    }
}
