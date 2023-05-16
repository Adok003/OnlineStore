package com.example.onlinestore.Controller;

import com.example.onlinestore.Entity.Category;
import com.example.onlinestore.Repository.CategoryRepository;
import com.example.onlinestore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    //Third version

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return new ArrayList<>(categoryRepository.findAll());
    }

//    @GetMapping("/categories")
//    public String getAllCategories(Model model){
//        List<Category> categories = new ArrayList<>(categoryRepository.findAll());
//        model.addAttribute("categories", categories);
//        return "category";
//    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Integer id){
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestParam("name") String name, @RequestParam("image") MultipartFile file) throws IOException {
        return categoryRepository.save(new Category(name, file.getBytes(), file.getOriginalFilename(), file.getContentType()));
    }

    @PutMapping("categories/{id}")
    public Category updateCategory(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("image") MultipartFile file) throws IOException{
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(name);
        category.setImage(file.getBytes());
        category.setType(file.getContentType());
        category.setImgName(file.getOriginalFilename());
        return categoryRepository.save(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id") Integer id){
        categoryRepository.deleteById(id);
    }

    //Second version
//    @GetMapping("/category/{category_id}")
//    public ResponseEntity<Category> getPageById(@PathVariable("category_id") Integer category_id) {
//        Optional<Category> category = categoryRepository.findById(category_id);
//        if(category.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(category.get(), HttpStatus.OK);
//    }
//
//    @PostMapping("/category/{category_id}/product")
//    public ResponseEntity<Category> createCategory(@PathVariable("category_id") Integer category_id, @RequestBody Product product) {
//        Optional<Category> optionalCategory = categoryRepository.findById(category_id);
//        if(optionalCategory.get() == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        Category category = optionalCategory.get();
//        if(product.getProduct_id() != null) {
//            Optional<Product> optPost = productRepository.findById(product.getProduct_id());
//            if(optPost.get() != null) {
//                product.setCategory(category);
//                productRepository.save(product);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } else {
//            productRepository.save(new Product(category, product.getProduct_name(), product.getProduct_color(), product.getProduct_size(), product.getProduct_quantity(), product.getPrice()));
//        }
//        return new ResponseEntity<>(category, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/category")
//    public ResponseEntity<Category> creatCategory(@RequestBody Category category) {
//        Category resCategory = categoryRepository.save(new Category(category.getCategoryName()));
//        return new ResponseEntity<>(resCategory, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/categoy/{category_id}")
//    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("category_id") Integer category_id) {
//        categoryRepository.deleteById(category_id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


    //First Version wich does not work
//    @GetMapping("/category")
//    public List<Category> showAllCategory(@RequestParam(required = false) String category_name){
//        List<Category> categories = new ArrayList<>();
//        if (category_name == null){
//            categoryRepository.findAll().forEach(categories::add);
//        }else{
//            categoryRepository.findByCategoryName(category_name).forEach(categories::add);
//        }
//        return categories;
//    }
//
//    @GetMapping("/category/{category_id}")
//    public Category showCategory(@PathVariable(value = "category_id") Integer category_id){
//        return categoryRepository.findById(category_id).orElseThrow();
//    }
//
//    @PostMapping("/category")
//    public Category saveCategory(@RequestBody Category category){
//        return categoryRepository.save(new Category(category.getCategoryName()));
//    }
//
//    @PutMapping("/category/{category_id}")
//    public Category replaceCategory(@RequestBody Category newCategory, @PathVariable(value = "category_id") Integer category_id){
//        Category category = categoryRepository.findById(category_id).orElseThrow();
//        category.setCategoryName(newCategory.getCategoryName());
//        category.setProducts(newCategory.getProducts());
//
//        return categoryRepository.save(category);
//    }
//
//    @DeleteMapping("/category/{category_id}")
//    public void deleteCategory(@PathVariable(value = "category_id") Integer category_id){
//        categoryRepository.deleteById(category_id);
//    }
}
