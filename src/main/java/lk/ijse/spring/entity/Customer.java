package lk.ijse.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: Customer
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-20, Wednesday
 **/



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @Column(name = "cus_id")
    private String cus_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;
}
