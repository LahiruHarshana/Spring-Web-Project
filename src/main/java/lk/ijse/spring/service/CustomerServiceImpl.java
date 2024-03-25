package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/

@Component
public class CustomerServiceImpl implements CustomerService{

    ArrayList<CustomerDTO> customerList = new ArrayList<>();
    @Override
    public List<CustomerDTO> getAllCustomers() {
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
    public void saveCustomer(CustomerDTO customerDTO) {
        customerList.add(customerDTO);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        for(CustomerDTO customer : customerList){
            if(customer.getId().equals(customerDTO.getId())){
                customerList.set(customerList.indexOf(customer),customerDTO);
                break;
            }
        }
    }

    @Override
    public void deleteCustomer(String id) {
        for(CustomerDTO customer : customerList){
            if(customer.getId().equals(id)){
                customerList.remove(customer);
                break;
            }
        }
    }
}
