package lk.ijse.spring.api;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*")

public class CustomerController {


    @Autowired //property injection
    CustomerService customerService;
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public List<CustomerDTO> getAllCustomers(){
            return customerService.getAllCustomers();
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.CREATED)
        public boolean saveCustomer(@RequestBody CustomerDTO customer){
           return customerService.saveCustomer(customer);
        }

        @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public boolean updateCustomer(@RequestBody CustomerDTO customer){
            System.out.println(customer.getName());
            return customerService.updateCustomer(customer);
        }

        @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean deleteCustomer(@PathVariable("id") String id){
            return customerService.deleteCustomer(id);
        }

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public CustomerDTO getCustomer(@PathVariable("id") String id){
            return customerService.getCustomerDetails(id);
        }
}
