package shop.controllers;

import shop.model.entities.OrderEntity;
import shop.services.CountService;
import shop.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiOrderController {
    private final OrderService orderService;
    private final CountService countService;

    public ApiOrderController(OrderService orderService, CountService countService) {
        this.orderService = orderService;
        this.countService = countService;
    }
    @PostMapping(value = "/orders/")
    public ResponseEntity<Integer> addOrder(@RequestBody OrderEntity order)
    {
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<List<OrderEntity>> getOrders(@PathVariable Integer id)
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

    @GetMapping("/orders/")
    public ResponseEntity<List<OrderEntity>> getOrdersMoreThenHundred(){
        return ResponseEntity.ok(countService.getOrdersMoreThenHundred());
    }
}
