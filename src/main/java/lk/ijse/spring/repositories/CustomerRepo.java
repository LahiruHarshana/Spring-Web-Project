package lk.ijse.spring.repositories;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : L.H.J
 * @File: CustomerRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
