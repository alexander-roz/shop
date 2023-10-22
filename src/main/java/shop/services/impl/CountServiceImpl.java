package shop.services.impl;

import org.springframework.stereotype.Service;
import shop.model.entities.OrderEntity;
import shop.model.entities.ProductEntity;
import shop.model.repositories.OrderRepository;
import shop.model.repositories.ProductRepository;
import shop.services.CountService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountServiceImpl implements CountService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CountServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getProductListOfTheOrder(OrderEntity order) {
        List<ProductEntity> productsInOrder = new ArrayList<>();
        for(OrderEntity orderEntity:orderRepository.findOrderEntitiesByOrderID(order.getOrderID())){
            productsInOrder.add(orderEntity.getProductID());
        }
        return productsInOrder;
    }

    @Override
    public Double getTheCheckPrice(OrderEntity order) {
        List<ProductEntity> productEntities = getProductListOfTheOrder(order);
        double checkPrice = 0.0;
        for(ProductEntity product:productEntities){
            checkPrice =+ product.getPrice();
        }
        return checkPrice;
    }

    @Override
    public List<OrderEntity> getOrdersMoreThenHundred() {
        List<OrderEntity> orders = new ArrayList<>();
        for(OrderEntity orderEntity:orderRepository.findAll()){
            if(getTheCheckPrice(orderEntity) > 100.0){
                orders.add(orderEntity);
            }
        }
        return orders;
    }
}
