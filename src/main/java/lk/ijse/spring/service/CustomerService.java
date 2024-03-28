package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetails(String id);
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);

}
