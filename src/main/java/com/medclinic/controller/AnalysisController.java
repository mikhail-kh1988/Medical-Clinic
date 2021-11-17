package com.medclinic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.DescribeAnalysisDto;
import com.medclinic.dto.ResultByAnalysisDto;
import com.medclinic.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IAnalysisService analysisService;

    @PostMapping("/create")
    public ResponseEntity<String> createNewAnalysis(@RequestBody DescribeAnalysisDto dto){
        return new ResponseEntity<>("success! id:"+analysisService.createAnalysis(dto).getId(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllAnalysis() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(analysisService.findAllAnalysis()), HttpStatus.OK);
    }

    @PostMapping("/createResult")
    public ResponseEntity<String> createResultByAnalysis(@RequestBody ResultByAnalysisDto dto){
        return new ResponseEntity<>(analysisService.createResultByAnalysis(dto).getTitle(), HttpStatus.OK);
    }

    @PostMapping("/updateAnalysis/{id}")
    public ResponseEntity<String> updateAnalysis(@RequestBody DescribeAnalysisDto dto, @PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<String>(mapper.writeValueAsString(analysisService.updateAnalysis(dto, id)), HttpStatus.OK);
    }

    @GetMapping("/deleteAnalysis/{id}")
    public ResponseEntity<String> deleteAnalysis(@PathVariable long id){
        analysisService.deleteAnalysis(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> findAnalysisByID(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(analysisService.findAnalysisByID(id)), HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<String> findAnalysisByName(@PathVariable String name) throws JsonProcessingException {
        return new ResponseEntity<String>(mapper.writeValueAsString(analysisService.findByAnalysisByName(name)), HttpStatus.OK);
    }
}
