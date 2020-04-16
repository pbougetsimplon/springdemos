package co.simplon.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Category;
import co.simplon.service.CategoryService;

/**
 * This controller is in charge of responding to http calls on /api/category.
 * It can provide movie category related data to authenticated users. Creator or Admin users may create new categories.
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Method to list all categories.
     * This method is restricted to authenticated users.
     * @return the list of movie categories from the database.
     */
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    /**
     * Method to create a new category.
     * This method is restricted to Creator or Admin users.
     * @param newCategory the new category to create.
     * @return the new created category.
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CREATOR')")
    public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {
        // TODO: Error handling
        return ResponseEntity.ok(categoryService.createNewCategory(newCategory));
    }
}
