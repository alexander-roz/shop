package shop.controllers;

import shop.model.entities.ProductEntity;
import shop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiProductController {

    private final ProductService productService;

    public ApiProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/products/")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductEntity product)
    {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable Integer id)
    {
        return ResponseEntity.ok(productService.getProductByID(id));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> removeProduct(ProductEntity product, @PathVariable String id){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @DeleteMapping("/products/")
    public ResponseEntity<?> deleteAllProducts(){
        return ResponseEntity.ok(productService.deleteAllProducts());
    }

}
