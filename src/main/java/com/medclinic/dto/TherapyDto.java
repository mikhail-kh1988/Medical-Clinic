package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TherapyDto {

    @NotBlank
    private String Therapy;

    @NotBlank
    private String describeComplaint;

    @Min(1)
    private long diseaseID;

}
