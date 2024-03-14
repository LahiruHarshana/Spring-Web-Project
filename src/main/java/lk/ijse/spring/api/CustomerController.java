package lk.ijse.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return "All Customers";
        }
}
