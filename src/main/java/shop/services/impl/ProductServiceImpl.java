package shop.services.impl;

import org.springframework.stereotype.Service;
import shop.dto.RequestTask;
import shop.model.entities.ProductEntity;
import shop.model.repositories.ProductRepository;
import shop.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer addProduct(ProductEntity product) {
        productRepository.save(product);
        return product.getProductID();
    }

    @Override
    public RequestTask deleteProduct(ProductEntity product) {
        if(productRepository.existsById(product.getProductID())){
            productRepository.delete(product);
            return new RequestTask(true);
        }
        else {
            return new RequestTask(false, "Product was not found");
        }
    }

    @Override
    public RequestTask deleteAllProducts() {
        productRepository.deleteAll();
        if(productRepository.findAll().size() == 0){
            return new RequestTask(true);
        }
        else{
            return new RequestTask(false, "Products were not deleted");
        }
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductByID(int id) {
        return productRepository.findProductEntityByProductID(id);
    }
}
