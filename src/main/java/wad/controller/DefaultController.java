package wad.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import wad.domain.Category;
import wad.domain.News;
import wad.repository.NewsRepository;

@Controller
public class DefaultController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("*")
    public String defaultRedirect() {
        if (this.newsRepository.findByOtsikko("fake news!") == null) {
            News news = new News();
//            news.setKategoriat(new ArrayList());
//            news.getKategoriat().add(new Category());
//            news.setTime(new Date());
            news.setKirjoittaja("Minä");
            news.setOtsikko("fake news!");
            this.newsRepository.save(news);
        }
        return "redirect:/news";
    }
}
