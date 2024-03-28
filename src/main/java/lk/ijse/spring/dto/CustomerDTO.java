package lk.ijse.spring.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    @Null(message = "Customer ID must be null")
    private String cus_id;

    @NotBlank(message = "Name can not be null")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Name should only contain alphabetical characters")
    private String name;

    @NotBlank(message = "Address can not be null")
    private String address;

    @NotNull(message = "Salary can not be null")
    private Double salary; // Use Double instead of double to allow null values
}
