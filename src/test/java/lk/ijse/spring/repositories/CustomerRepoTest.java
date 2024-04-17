package lk.ijse.spring.repositories;

import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : L.H.J
 * @File: CustomerRepoTest
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-04, Thursday
 **/

@WebAppConfiguration
@SpringJUnitConfig(classes = {lk.ijse.spring.config.WebRootConfig.class})
@Transactional
class CustomerRepoTest {


    @Autowired
    CustomerRepo customerRepo;

    void addAllCustomer(){
        Customer customer = new Customer("C001","Lahiru","Galle",1200.00);
        Customer customer1 = new Customer("C002","Kamal","Colombo",1200.00);
        Customer customer2 = new Customer("C003","Nimal","Kandy",1200.00);
        Customer customer3 = new Customer("C004","Sunil","Galle",1200.00);
        Customer customer4 = new Customer("C005","Amal","Galle",1200.00);
        Customer customer5 = new Customer("C006","Kamal","Galle",1200.00);

        customerRepo.save(customer);
    }

    @Test
    void findCustomersByCus_nameLike() {

    }

    @Test
    void findCustomerByCus_nameAndAddress() {
    }
    @Test
    void countCustomersByAddressStartsWith() {
        addAllCustomer();
        int count = customerRepo.countCustomersByAddressStartsWith("Galle");
        assertNotEquals(0,count);
    }

    @Test
    void getAllCustomers() {
        addAllCustomer();
//        int count = customerRepo.getAllCustomersWith().size();
//        assertNotEquals(0,count);
    }

    void getCustomersByNameAndAddress() {
        addAllCustomer();
        List<Customer> customers = customerRepo.getCustomersByNameAndAddress("Kamal", "Galle");
        assertNotEquals(0,customers.size());
    }


}