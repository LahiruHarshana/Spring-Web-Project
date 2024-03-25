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
    @Autowired
    ModelMapper modelMapper;

    public CustomerDTO fromCustomerEntity(Customer customer){
        return modelMapper.map(customer,CustomerDTO.class);
    }

}
