package lk.ijse.spring.service.custom.impl;

import jakarta.transaction.Transactional;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.repositories.CustomerRepo;
import lk.ijse.spring.service.custom.CustomerService;
import lk.ijse.spring.service.exception.DuplicateRecordException;
import lk.ijse.spring.service.exception.NotFoundException;
import lk.ijse.spring.service.util.Transformer;
import lk.ijse.spring.service.util.UtilMatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/

@Service
@Transactional
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
        if (!customerRepo.existsById(id)){
            throw new NotFoundException("No customer exist for the provided id");
        }
        return transformer.fromCustomerEntity(customerRepo.findById(id).get());
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCus_id())){
            throw new DuplicateRecordException("Customer already exist for the provided id");
        }
        customerDTO.setCus_id(UtilMatter.generateID());
        return transformer.fromCustomerEntity(customerRepo.save(transformer.toCustomerEntity(customerDTO)));
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCus_id())){
            throw new NotFoundException("No customer exist for the provided id");
        }
        customerRepo.save(transformer.toCustomerEntity(customerDTO));
        return customerDTO;
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)){
            throw new NotFoundException("No customer exist for the provided id");
        }
        customerRepo.deleteById(id);
    }
}
