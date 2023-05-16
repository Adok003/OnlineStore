package com.example.onlinestore.Repository;

import com.example.onlinestore.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByImgName(String imgName);
}
