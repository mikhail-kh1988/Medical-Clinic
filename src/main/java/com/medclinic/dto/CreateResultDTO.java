package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateResultDTO {

    public long analysisID;
    public long serviceID;
    public long doctorID;
    public long clientID;

}
