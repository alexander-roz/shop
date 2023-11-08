package shop.config;

import org.springframework.ui.Model;
import shop.ShopApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.model.entities.CustomerEntity;
import shop.model.repositories.CustomerRepository;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller extends SpringBootServletInitializer {

    private final CustomerRepository customerRepository;

    public Controller(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(ShopApplication.class);
    }

    @RequestMapping(value = "/")
    public String login(Model model)
    {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        ArrayList<CustomerEntity> customers = new ArrayList<>(customerRepository.findAll());
        model.addAttribute("customers", customers);
        model.addAttribute("customersCount", customers.size());
        return "index";
    }
    @RequestMapping(value = "/sales")
    public String sales(Model model){
        return "sales";
    }
}
