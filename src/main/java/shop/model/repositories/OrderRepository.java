package shop.model.repositories;

import shop.model.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findOrderEntitiesByOrderID(int id);
}
