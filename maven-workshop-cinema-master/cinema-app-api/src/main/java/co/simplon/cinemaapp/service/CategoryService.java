package co.simplon.cinemaapp.service;

import co.simplon.cinemaapp.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

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
