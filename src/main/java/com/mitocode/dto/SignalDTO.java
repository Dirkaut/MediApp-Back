package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mitocode.model.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignalDTO {

    @EqualsAndHashCode.Include
    private Integer idSignal;
    private Integer idPatient;
    private String fullName;
    @JsonBackReference
    private PatientDTO patient;
    @NotNull
    private LocalDateTime date;
    private String temperature;
    private String pulse;
    private String breathingRhythm;



}
