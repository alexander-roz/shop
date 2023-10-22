package shop.services.impl;

import org.springframework.stereotype.Service;
import shop.dto.RequestTask;
import shop.model.entities.OrderEntity;
import shop.model.repositories.OrderRepository;
import shop.services.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Integer addOrder(OrderEntity order) {
        orderRepository.save(order);
        return order.getOrderID();
    }

    @Override
    public RequestTask deleteOrder(OrderEntity order) {
        if(orderRepository.existsById(order.getOrderID())){
            orderRepository.delete(order);
            return new RequestTask(true);
        }
        else {
            return new RequestTask(false, "Order was not found");
        }
    }

    @Override
    public RequestTask deleteAllOrders() {
        orderRepository.deleteAll();
        if(orderRepository.findAll().size() == 0){
            return new RequestTask(true);
        }
        else{
            return new RequestTask(false, "Orders were not deleted");
        }
    }

    @Override
    public List<OrderEntity> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> getOrderByID(int id) {
        return orderRepository.findOrderEntitiesByOrderID(id);
    }

}
