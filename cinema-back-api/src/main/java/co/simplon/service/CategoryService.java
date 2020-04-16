package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Category;

@Service
public interface CategoryService {

    /**
     * Method that lists all movie categories.
     * @return the list of all movie categories.
     */
    List<Category> findAllCategories();

    /**
     * Method that creates a new category.
     * @param newCategory the new category to create.
     * @return the created category.
     */
    Category createNewCategory(Category newCategory);
}
