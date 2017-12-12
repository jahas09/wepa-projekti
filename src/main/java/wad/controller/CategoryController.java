
package wad.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Category;
import wad.repository.CategoryRepository;

@Controller
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("news", this.categoryRepository.findAll());
        return "redirect:/news";
    }
    
    @PostMapping("/categories")
    public String postNews(@RequestParam String name) {
        if(this.categoryRepository.findByName(name) == null){
            Category kategoria = new Category();
            kategoria.setName(name);
            kategoria.setUutiset(new ArrayList());
            this.categoryRepository.save(kategoria);
        }
        return "redirect:/news";
    }

}
