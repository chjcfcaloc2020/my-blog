package com.chjcfcaloc2020.my_blog.service;

import com.chjcfcaloc2020.my_blog.dto.request.CreateCategoryRequest;
import com.chjcfcaloc2020.my_blog.exception.payload.ResourceAlreadyExistsException;
import com.chjcfcaloc2020.my_blog.mapper.CategoryMapper;
import com.chjcfcaloc2020.my_blog.model.Category;
import com.chjcfcaloc2020.my_blog.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Transactional
    public Category createCategory(CreateCategoryRequest request) {
        if (categoryRepository.existsByNameIgnoreCase(request.getName())) {
            throw new ResourceAlreadyExistsException("Category already exists with name: " + request.getName());
        }
        Category newCategory = categoryMapper.toEntity(request);
        return categoryRepository.save(newCategory);
    }

    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalStateException("Category has posts associated with its");
            }
            categoryRepository.deleteById(id);
        }
    }

}
