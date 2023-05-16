package com.example.onlinestore.Repository;

import com.example.onlinestore.Entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    List<Basket> findByUser_Id(Integer id);
}
