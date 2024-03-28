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
        return customerRepo.findAll().stream()
                .map(customer -> transformer.fromCustomerEntity(customer)).toList();
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        return transformer.fromCustomerEntity(customerRepo.findById(id).get());


    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerRepo.save(transformer.toCustomerEntity(customerDTO));

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        customerRepo.save(transformer.toCustomerEntity(customerDTO));

    }

    @Override
    public void deleteCustomer(String id) {
        customerRepo.deleteById(id);

    }
}
