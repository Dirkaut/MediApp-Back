package com.mitocode.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer idPatient;

    @NotNull
    //@NotEmpty
    //@NotBlank
    @Size(min = 3, max = 70, message = "{firstname.size}")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 70, message = "{lastname.size}")
    private String lastName;

    @NotNull
    private String dni;

    @NotNull
    private String address;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String phone;

    @Email
    private String email;

    private List<SignalDTO> signals;

    /*@Max(value = 11)
    @Min(value = 1)
    private int age;*/
}
