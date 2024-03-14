package lk.ijse.spring.api;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author : L.H.J
 * @File: CustomerController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/

@RestController
@RequestMapping("/customer")
public class CustomerController {

        @GetMapping
        public String getAllCustomers(){
            ArrayList<CustomerDTO> customerList = new ArrayList<>();
            customerList.add(new CustomerDTO("C001","Lahiru","Galle"));
            customerList.add(new CustomerDTO("C002","Savinda","Matara"));
            customerList.add(new CustomerDTO("C003","Theekshana","Colombo"));
            return "All Customers";
        }
}
