package lk.ijse.spring.service.custom.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.repositories.CustomerRepo;
import lk.ijse.spring.service.custom.CustomerService;
import lk.ijse.spring.service.util.Transformer;
import lk.ijse.spring.service.util.UtilMatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author : L.H.J
 * @File: CustomerServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/

@Service
public class CustomerServiceImpl implements CustomerService {

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
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(UtilMatter.generateID());
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