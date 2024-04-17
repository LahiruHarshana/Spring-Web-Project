package lk.ijse.spring.repositories;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerRepo
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-25, Monday
 **/
public interface CustomerRepo extends JpaRepository<Customer,String> {
    List<Customer> findCustomersByCus_nameLike(String cus_name);
    Customer findCustomerByCus_nameAndAddress(String cus_name, String address);
    int countCustomersByAddressStartsWith(String cus_name);
    @Query( value = "SELECT * FROM customer",nativeQuery = true)
    List<Customer> getAllCustomersWith();
    /* positional parameter*/
    @Query(value = "select * from customer where cus_name = ?1 AND address = ?2",nativeQuery = true)
    List<Customer> getCustomersByNameAndAddress(String name, String address);

    /* named parameter*/
    @Query(value = "select * from customer where cus_name = :name AND address = :address",nativeQuery = true)
    List<Customer> getCustomersByNameAndAddressWithNamedParameter(@Param("cus_name") String name,@Param("cus_id") String address);

    

}
