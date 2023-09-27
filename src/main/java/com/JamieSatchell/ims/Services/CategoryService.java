package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Category;
import com.JamieSatchell.ims.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }


    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

}
