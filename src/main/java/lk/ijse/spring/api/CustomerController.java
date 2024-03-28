package lk.ijse.spring.api;

import jakarta.validation.Valid;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*")

public class CustomerController {
    @Autowired
    CustomerService customerService;
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public List<CustomerDTO> getAllCustomers(){
            return customerService.getAllCustomers();
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.CREATED)
        public void saveCustomer(@Valid @RequestBody CustomerDTO customer){
            customerService.saveCustomer(customer);

        }

        @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public void updateCustomer( @Valid @RequestBody CustomerDTO customer){
            System.out.println(customer.getName());
             customerService.updateCustomer(customer);
        }

        @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteCustomer(@PathVariable("id") String id){
             customerService.deleteCustomer(id);
        }

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public CustomerDTO getCustomer(@PathVariable("id") String id){
            return customerService.getCustomerDetails(id);
        }
}
