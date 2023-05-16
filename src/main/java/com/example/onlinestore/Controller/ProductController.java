package com.example.onlinestore.Controller;

import com.example.onlinestore.Entity.Product;
import com.example.onlinestore.Repository.CategoryRepository;
import com.example.onlinestore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //Third version
    @GetMapping("/categories/{id}/products")
    public List<Product> getAllProductsByCategory(@PathVariable("id") Integer id){
        if (!categoryRepository.existsById(id)){
            System.out.println("Not found id" + id);
        }

        return productRepository.findByCategory_Id(id);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productRepository.findById(id).orElseThrow();
    }

    @PostMapping("/categories/{id}/products")
    public Product addProduct(@PathVariable("id") Integer id, @RequestBody Product product){
        return categoryRepository.findById(id)
                .map(category -> {
                    product.setCategory(category);
                    return productRepository.save(product);
                }).orElseThrow();
    }

    @PutMapping("products/{id}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable("id") Integer id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setColor(newProduct.getColor());
                    product.setName(newProduct.getName());
                    product.setQuantity(newProduct.getQuantity());
                    product.setSize(newProduct.getSize());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                }).orElseThrow();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(value = "id") Integer id){
        productRepository.deleteById(id);
    }

    //Second version
//    @GetMapping("/product/{product_id}")
//    public ResponseEntity<Product> getPostById(@PathVariable("product_id") Integer product_id) {
//        Optional<Product> product = productRepository.findById(product_id);
//        if(product.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(product.get(), HttpStatus.OK);
//    }
//
//    @PostMapping("/product")
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        Product resProduct = productRepository.save(new Product(product.getName(), product.getColor(), product.getSize(), product.getQuantity(), product.getPrice()));
//        return new ResponseEntity<>(resProduct, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/product/{product_id}")
//    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("product_id") Integer product_id) {
//        productRepository.deleteById(product_id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


//First Version wich does not work
//    @GetMapping("/products")
//    public List<Product> showAllProducts(){
//        return new ArrayList<>(productRepository.findAll());
//    }
//    @GetMapping("/category/{category_id}/products")
//    public List<Product> getAllProducts(@PathVariable(value = "category_id") Integer category_id){
//        if (!categoryRepository.existsById(category_id)){
//            System.out.println("Not found Category with id = " + category_id);
//        }
//
//        return productRepository.findByCategory_CategoryId(category_id);
//    }
//
//    @GetMapping("/product/{product_id}")
//    public Product showProduct(@PathVariable(value = "product_id") Integer product_id){
//        return productRepository.findById(product_id).orElseThrow();
//    }
//
////    @PostMapping("/product")
////    public Product saveProduct(@RequestBody Product product){
////        return productRepository.save(product);
////    }
//    @PostMapping("/category/{category_id}/product")
//    public Product saveProduct(@PathVariable(value = "category_id") Integer category_id ,@RequestBody Product product){
//        return categoryRepository.findById(category_id)
//                .map(category -> {
//                    product.setCategory(category);
//                    return productRepository.save(product);
//                }).orElseThrow();
//    }
//
//    @PutMapping("/product/{product_id}")
//    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Integer product_id){
//        return productRepository.findById(product_id)
//                .map(product -> {
//                    product.setProduct_color(newProduct.getProduct_color());
//                    product.setProduct_name(newProduct.getProduct_name());
//                    product.setProduct_quantity(newProduct.getProduct_quantity());
//                    product.setProduct_size(newProduct.getProduct_size());
//                    product.setPrice(newProduct.getPrice());
////                    product.setCategory(newProduct.getCategory());
//                    return productRepository.save(product);
//                }).orElseThrow();
//    }
//    @DeleteMapping("/product/{product_id}")
//    public void deleteProduct(@PathVariable(value = "product_id") Integer product_id){
//        productRepository.deleteById(product_id);
//    }
}
