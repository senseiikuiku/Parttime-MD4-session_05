package com.ra.session_05.model.dto.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ra.session_05.validate.CustomerUnique;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CustomerRequestDTO {
    @NotBlank(message = "Khong duoc rong")
    private String fullName;
    @NotBlank(message="Khong duoc rong")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$",
            message = "email khong dung")
    @CustomerUnique(message = "Email da ton tai")
    private String email;
    @NotBlank(message="Khong duoc rong")
    @Size(min = 6,message = "Toi thieu 6 ky tu")
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Past(message = "Ngay sinh phai la ngay qua khu")
    private LocalDate birthday;
}
