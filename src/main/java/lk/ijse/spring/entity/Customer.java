package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "cus_id",length = 30)
    private String cus_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;
}
