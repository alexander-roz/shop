package shop.model.repositories;

import shop.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findProductEntityByProductID(int id);
}
