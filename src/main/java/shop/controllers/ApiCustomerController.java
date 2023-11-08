package shop.controllers;

import shop.model.entities.CustomerEntity;
import shop.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/")
public class ApiCustomerController {

    private final CustomerService customerService;

    public ApiCustomerController(CustomerService customerservice) {
        this.customerService = customerservice;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Integer> addCustomer(@RequestBody CustomerEntity customer)
    {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable Integer id)
    {
        return ResponseEntity.ok(customerService.getCustomerByID(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeCustomer(CustomerEntity customer, @PathVariable int id){
        return ResponseEntity.ok(customerService.deleteCustomer(customer));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllCustomers(){
        return ResponseEntity.ok(customerService.deleteAllCustomers());
    }
}
