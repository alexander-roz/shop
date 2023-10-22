package shop.controllers;

import shop.model.entities.OrderEntity;
import shop.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiOrderController {
    private final OrderService orderService;

    public ApiOrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping(value = "/orders/")
    public ResponseEntity<Integer> addOrder(@RequestBody OrderEntity order)
    {
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable Integer id)
    {
        return ResponseEntity.ok(orderService.getOrderByID(id));
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> removeOrder(OrderEntity order, @PathVariable int id){
        return ResponseEntity.ok(orderService.deleteOrder(order));
    }

    @DeleteMapping("/orders/")
    public ResponseEntity<?> deleteAllOrders(){
        return ResponseEntity.ok(orderService.deleteAllOrders());
    }
}
