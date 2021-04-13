package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.Category;
import co.edu.una.UNalmanaqueback.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @PostMapping(path = "/category")
    @ResponseBody
    public String addCategory (@RequestBody Category category) {
        categoryRepository.save(category);
        return "saved";
    }
    /*
    @PostMapping(path = "/category")
    public @ResponseBody String addCategory (@RequestParam String categoryName) {
        Category newCategory = new Category();
        newCategory.setCategoryName(categoryName);
        categoryRepository.save(newCategory);
        return "Saved";
    }
    */

    @GetMapping(path = "/category")
    public @ResponseBody Iterable<Category> getAllUsers(){
        return categoryRepository.findAll();
    }
}
