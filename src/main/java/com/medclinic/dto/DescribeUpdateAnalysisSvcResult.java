package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DescribeUpdateAnalysisSvcResult {

    private String result;
    private String marks;
    private long whoCheckedID;
}
