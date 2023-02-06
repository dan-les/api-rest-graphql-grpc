package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
