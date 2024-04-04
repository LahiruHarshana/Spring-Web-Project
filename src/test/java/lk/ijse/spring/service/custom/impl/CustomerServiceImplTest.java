package lk.ijse.spring.service.custom.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.custom.CustomerService;
import lk.ijse.spring.service.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author : L.H.J
 * @File: CustomerServiceImplTest
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-04, Thursday
 **/


//@ExtendWith({SpringExtension.class})
//@ContextConfiguration(classes = {lk.ijse.spring.config.WebRootConfig.class})

@WebAppConfiguration
@SpringJUnitConfig(classes = {lk.ijse.spring.config.WebRootConfig.class})
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService ;
    @Test
    void getAllCustomers() {
        CustomerDTO customerDTO = new CustomerDTO("C00111","Lahiru","Galle",1200.00);
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();

        assertNotEquals(null,allCustomers);


    }

    @Test
    void getCustomerDetails() {
        assertThrows(NotFoundException.class,()->{
            customerService.getCustomerDetails("C00111");
        });
    }

    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("C00111","Lahiru","Galle",1200.00);
        CustomerDTO customer = customerService.saveCustomer(customerDTO);
        assertNotEquals(null,customer);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("C111","Lahiru","Galle",1200.00);
        CustomerDTO customer = customerService.updateCustomer(customerDTO);
        assertThrows(NotFoundException.class,()->{
            customerService.updateCustomer(customerDTO);
        });
    }

    @Test
    void deleteCustomer() {

    }
}