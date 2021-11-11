package com.medclinic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.DescribeAnalysisDTO;
import com.medclinic.dto.ResultByAnalysisDTO;
import com.medclinic.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private IAnalysisService analysisService;

    @PostMapping("/create")
    public ResponseEntity<String> createNewAnalysis(@RequestBody DescribeAnalysisDTO dto){
        analysisService.createAnalysis(dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllAnalysis() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(analysisService.findAllAnalysis()), HttpStatus.OK);
    }

    @PostMapping("/createResult")
    public ResponseEntity<String> createResultByAnalysis(@RequestBody ResultByAnalysisDTO dto){
        analysisService.createResultByAnalysis(dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }
}
