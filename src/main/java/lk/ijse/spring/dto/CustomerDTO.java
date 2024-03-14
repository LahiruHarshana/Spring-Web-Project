package lk.ijse.spring.dto;

import java.io.Serializable;

/**
 * @author : L.H.J
 * @File: CustomerDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-14, Thursday
 **/
public class CustomerDTO implements Serializable {
    private String id;
    private String name;
    private String address;

    public CustomerDTO(){
    }

    public CustomerDTO(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
