package lk.ijse.spring.dto;

import java.io.Serializable;
import lombok.*;
/**
 * @author : L.H.J
 * @File: CustomerDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    private String cus_id;
    private String name;
    private String address;
    private double salary;

}
