package shop.services;

import shop.dto.RequestTask;
import shop.model.entities.CustomerEntity;

import java.util.List;
public interface CustomerService {
    Integer addCustomer(CustomerEntity customer);
    RequestTask deleteCustomer(CustomerEntity customer);
    RequestTask deleteAllCustomers();
    List<CustomerEntity> findAllCustomers();
    CustomerEntity getCustomerByID(int id);
}
