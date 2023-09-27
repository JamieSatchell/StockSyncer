package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Category;
import com.JamieSatchell.ims.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public void deleteCategoryById(Long id) throws Exception {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            if(category.getProducts().isEmpty()) {
                categoryRepository.deleteById(id);
            } else {
                throw new Exception("Cannot delete category as it has associated products.");
            }
        } else {
            throw new Exception("Category with id " + id + " not found.");
        }
    }

}
