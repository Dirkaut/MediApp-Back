package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mitocode.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignalDTO {

    @EqualsAndHashCode.Include
    private Integer idSignal;
    private Integer idPatient;
    @JsonBackReference
    private PatientDTO patient;
    private String date;
    private String temperature;
    private String pulse;
    private String breathingRhythm;

}
