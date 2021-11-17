package com.medclinic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicesClientDto {
    private long clientID;
    private long analysisID;
    private long serviceID;
    private long doctorID;

}
