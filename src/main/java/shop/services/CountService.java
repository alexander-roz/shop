package shop.services;

import shop.model.entities.OrderEntity;
import shop.model.entities.ProductEntity;

import java.util.List;

public interface CountService {

    List<ProductEntity> getProductListOfTheOrder(OrderEntity order);

    Double getTheCheckPrice(OrderEntity order);

    List<OrderEntity> getOrdersMoreThenHundred();
}
