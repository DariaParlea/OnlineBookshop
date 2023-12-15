package map.project.demo.controllers;


import map.project.demo.entities.Category;
import map.project.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{CategoryID}")
    public Category getCategoryById(@PathVariable int CategoryID) {
        return categoryRepository.findById(CategoryID)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + CategoryID));
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{CategoryID}")
    public Category updateCategory(@PathVariable int CategoryID, @RequestBody Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(CategoryID)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + CategoryID));

        existingCategory.setType(updatedCategory.getType());

        return categoryRepository.save(existingCategory);
    }

    @DeleteMapping("/{CategoryID}")
    public String deleteCategory(@PathVariable int CategoryID) {
        categoryRepository.deleteById(CategoryID);
        return "Category deleted successfully";
    }
}