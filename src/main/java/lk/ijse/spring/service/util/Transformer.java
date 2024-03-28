package lk.ijse.spring.service.util;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : L.H.J
 * @File: Transformer
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/

@Component
public class Transformer {
    ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CustomerDTO fromCustomerEntity(Customer customer){
        CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public Customer toCustomerEntity(CustomerDTO customerDTO){
        Customer customer = mapper.map(customerDTO, Customer.class);
        return customer;
    }
}
