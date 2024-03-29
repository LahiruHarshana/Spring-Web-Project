package lk.ijse.spring.api;

import jakarta.validation.Valid;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
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

        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        @ResponseStatus(HttpStatus.CREATED)
        public CustomerDTO saveCustomer(@Valid @RequestPart("cus_id") String cus_id,
                                        @RequestPart("name") String name,
                                        @RequestPart("address") String address,
                                        @RequestPart("salary") double salary,
                                        @RequestPart("profile_pic") String profile_pic){
            String s = Base64.getEncoder().encodeToString(profile_pic.getBytes());
            CustomerDTO customer = new CustomerDTO(cus_id, name, address, salary, s);
            return customerService.saveCustomer(customer);
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
