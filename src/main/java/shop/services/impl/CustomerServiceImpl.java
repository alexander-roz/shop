package shop.services.impl;

import org.springframework.stereotype.Service;
import shop.dto.RequestTask;
import shop.model.entities.CustomerEntity;
import shop.model.repositories.CustomerRepository;
import shop.services.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Integer addCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
        return customer.getCustomerID();
    }

    @Override
    public RequestTask deleteCustomer(CustomerEntity customer) {
        if(customerRepository.existsById(customer.getCustomerID())){
            customerRepository.delete(customer);
            return new RequestTask(true);
        }
        else {
            return new RequestTask(false, "Customer was not found");
        }
    }

    @Override
    public RequestTask deleteAllCustomers() {
        customerRepository.deleteAll();
        if(customerRepository.findAll().size() == 0){
            return new RequestTask(true);
        }
        else{
            return new RequestTask(false, "Customers were not deleted");
        }
    }

    @Override
    public List<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerByID(int id) {
        return customerRepository.findCustomerEntityByCustomerID(id);
    }
}
