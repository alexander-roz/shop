package shop.services;

import shop.dto.RequestTask;
import shop.model.entities.OrderEntity;

import java.util.List;
public interface OrderService {
    Integer addOrder (OrderEntity order);
    RequestTask deleteOrder (OrderEntity order);
    RequestTask deleteAllOrders ();
    List<OrderEntity> findAllOrders ();
    List<OrderEntity> getOrderByID(int id);

}
