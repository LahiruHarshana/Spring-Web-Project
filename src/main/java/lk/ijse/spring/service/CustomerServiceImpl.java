package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repositories.CustomerRepo;
import lk.ijse.spring.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    Transformer transformer;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(transformer.fromCustomerEntity(customer));
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        Customer customer = customerRepo.findById(id).get();
        return transformer.fromCustomerEntity(customer);

    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
         customerRepo.save(transformer.fromCustomerDTO(customerDTO));
         return true;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getSalary());
        customerRepo.save(customer);
        return true;
    }

    @Override
    public boolean deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return true;
    }
}
