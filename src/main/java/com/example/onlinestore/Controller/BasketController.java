package com.example.onlinestore.Controller;

import com.example.onlinestore.Entity.Basket;
import com.example.onlinestore.Entity.Product;
import com.example.onlinestore.Entity.User;
import com.example.onlinestore.Repository.BasketRepository;
import com.example.onlinestore.Repository.ProductRepository;
import com.example.onlinestore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {
    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{id}/baskets")
    public List<Basket> getAllBasketsByUser(@PathVariable("id") Integer id){
        if (!userRepository.existsById(id)){
            System.out.println("Not found id" + id);
        }

        return basketRepository.findByUser_Id(id);
    }

    @PostMapping("/{user_id}/{product_id}/baskets")
    public Basket saveBasket(@PathVariable("user_id") Integer user_id, @PathVariable("product_id") Integer product_id){
        User user = userRepository.findById(user_id).orElseThrow();
        Product product = productRepository.findById(product_id).orElseThrow();
        return basketRepository.save(new Basket(product, user));
    }

//    @PutMapping("/basket/{id}")
//    public Basket updateBasket(@PathVariable("id") Integer id){
//        return basketRepository.findById(id)
//                .map(basket -> {
//                    return basketRepository.save(basket);
//                }).orElseThrow();
//    }

    @DeleteMapping("/baskets/{id}")
    public void deleteBasket(@PathVariable("id") Integer id){
        basketRepository.deleteById(id);
    }
}
