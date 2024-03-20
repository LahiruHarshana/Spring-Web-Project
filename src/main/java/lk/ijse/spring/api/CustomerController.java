package lk.ijse.spring.api;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : L.H.J
 * @File: CustomerController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*")

public class CustomerController {

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ArrayList<CustomerDTO> getAllCustomers(){
            ArrayList<CustomerDTO> customerList = new ArrayList<>();
            customerList.add(new CustomerDTO("C001","Lahiru","Galle"));
            customerList.add(new CustomerDTO("C002","Kamal","Matara"));
            customerList.add(new CustomerDTO("C003","Nimal","Colombo"));
            return customerList;
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public boolean saveCustomer(@RequestBody CustomerDTO customer){
            System.out.println(customer);
            return true;
        }

        @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public boolean updateCustomer(@RequestBody CustomerDTO customer){
            System.out.println(customer);
            return true;
        }

        @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public boolean deleteCustomer(@PathVariable("id") String id){
            System.out.println(id);
            return true;
        }

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public CustomerDTO getCustomer(@PathVariable("id") String id){
            return new CustomerDTO(id,"Lahiru","Galle");
        }
}
