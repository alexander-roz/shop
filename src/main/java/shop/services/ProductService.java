package shop.services;

import shop.dto.RequestTask;
import shop.model.entities.ProductEntity;

import java.util.List;
public interface ProductService {
    Integer addProduct(ProductEntity product);
    RequestTask deleteProduct(ProductEntity product);
    RequestTask deleteAllProducts();
    List<ProductEntity> findAllProducts();
    ProductEntity getProductByID(int id);
}
