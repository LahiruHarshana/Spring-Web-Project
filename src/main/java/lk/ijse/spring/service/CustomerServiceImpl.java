package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
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
    ArrayList<CustomerDTO> customerList = new ArrayList<>();

    @Override
    public List<CustomerDTO> getAllCustomers() {
        customerList.add(new CustomerDTO("C00-001","Kamal","Colombo",12000));
        customerList.add(new CustomerDTO("C00-002","Nimal","Kandy",15000));
        customerList.add(new CustomerDTO("C00-003","Sunil","Galle",20000));
        return customerList;
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        for(CustomerDTO customerDTO : customerList){
            if(customerDTO.getId().equals(id)){
                return customerDTO;
            }
        }
        return null;
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
