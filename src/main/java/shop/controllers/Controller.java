package shop.controllers;

import shop.ShopApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

public class Controller extends SpringBootServletInitializer {
//    private final OrderService orderService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(ShopApplication.class);
    }

//    public Controller(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @RequestMapping(value = "/")
    public String login()
    {
        return "login";
    }

//    @RequestMapping(value = "/")
//    public String index(Model model)
//    {
//        ArrayList<OrderEntity> orders = new ArrayList<>(orderService.findAllOrders());
//        model.addAttribute("orders", orders);
//        model.addAttribute("ordersCount", orders.size());
//        return "index";
//    }

}
