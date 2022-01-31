package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DescribeUpdateAnalysisSvcResult {

    @NotBlank
    private String result;

    @NotBlank
    private String marks;

    @Positive
    private long checkerID;
}
