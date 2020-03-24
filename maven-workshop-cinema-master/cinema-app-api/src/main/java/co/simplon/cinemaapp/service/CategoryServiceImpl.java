package co.simplon.cinemaapp.service;

import co.simplon.cinemaapp.model.Category;
import co.simplon.cinemaapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createNewCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }
}
