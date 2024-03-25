package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repositories.CustomerRepo;
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
    CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        List<CustomerDTO> customerList = new ArrayList<>();
        for (Customer customer : all) {
            customerList.add(new CustomerDTO(customer.getCus_id(),customer.getName(),customer.getAddress(),customer.getSalary()));
        }
        return customerList;
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        Customer customer = customerRepo.findById(id).get();
        return new CustomerDTO(customer.getCus_id(),customer.getName(),customer.getAddress(),customer.getSalary());
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        customerList.add(customerDTO);
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        for(CustomerDTO customer : customerList){
            if(customer.getId().equals(customerDTO.getId())){
                customerList.set(customerList.indexOf(customer),customerDTO);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        for(CustomerDTO customer : customerList){
            if(customer.getId().equals(id)){
                customerList.remove(customer);
                return true;
            }
        }
        return false;
    }
}
