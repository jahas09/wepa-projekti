
package wad.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Category;
import wad.domain.News;
import wad.domain.NewsObject;
import wad.repository.CategoryRepository;
import wad.repository.NewsRepository;


@Controller
public class NewsController {
    
    @Autowired
    private NewsRepository newsRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/news")
    public String listNews(Model model) {
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "time");
        model.addAttribute("news", this.newsRepository.findAll(pageable));
        pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.Direction.DESC, "uutiset");
        model.addAttribute("kategoriat", this.categoryRepository.findAll(pageable));
        return "news";
    }
    
    @Secured("ROLE_USER")
    @PostMapping("/news")
    public String postNews(Model model, @Valid @ModelAttribute NewsObject newsObject, BindingResult bindingResult) {
        model.addAttribute("kategoriat", this.categoryRepository.findAll());
        if(bindingResult.hasErrors()){
            return "luoUutinen";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        News news = new News();
        news.setKategoriat(new ArrayList());
        String[] kategoriaIdt = newsObject.getKategoriat().split(",");
        for(String id : kategoriaIdt){
            news.getKategoriat().add(this.categoryRepository.getOne(Long.parseLong(id)));
        }
        news.setIngressi(newsObject.getIngressi());
        news.setOtsikko(newsObject.getOtsikko());
        news.setTeksti(newsObject.getTeksti());
        news.setKirjoittaja(auth.getName());
        news.setTime(new Date());
        this.newsRepository.save(news);
//        for(Category kategoria: news.getKategoriat()){
//            kategoria.getUutiset().add(news);
//            this.categoryRepository.save(kategoria);
//        }
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
    
    @Secured("ROLE_USER")
    @GetMapping("/sendNews")
    public String SendNews(Model model, @ModelAttribute NewsObject newsObject) {
        model.addAttribute("kategoriat", this.categoryRepository.findAll());
        return "luoUutinen";
    }
    
    @GetMapping("/news/category/{id}")
    public String listCategory(Model model, @PathVariable Long id) {
        Optional<Category> kategoria = this.categoryRepository.findById(id);
        if(!kategoria.isPresent()){
            return "redirect:/news";
        }
        model.addAttribute("uutiset", kategoria.get().getUutiset());
        model.addAttribute("kategoria", kategoria.get().getName());
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.Direction.DESC, "uutiset");
        model.addAttribute("kategoriat", this.categoryRepository.findAll(pageable));
        return "news";
    }
}
