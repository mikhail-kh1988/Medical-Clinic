package com.medclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.CreateResultDTO;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.service.IAnalysisSvcResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
public class AnalysisServiceResultController {

    @Autowired
    private IAnalysisSvcResultService resultService;

    @PostMapping("/createByService")
    public ResponseEntity<String> createResultByService(@RequestBody CreateResultDTO dto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<String>(mapper.writeValueAsString(resultService.createResultByMedService(dto).getTitle()), HttpStatus.OK);
    }

    @PostMapping("/createByAnalysis")
    public ResponseEntity<String> createResultByAnalysis(@RequestBody CreateResultDTO dto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<String>(mapper.writeValueAsString(resultService.createResultByAnalysis(dto).getTitle()), HttpStatus.OK);
    }

    @GetMapping("/getAllResultByClient/{id}")
    public ResponseEntity<String> getAllResultByClient(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByClient(id)), HttpStatus.OK);
    }

    @GetMapping("/getNotPaidResult")
    public ResponseEntity<String> getNotPaidResults() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByNotPaid()), HttpStatus.OK);
    }

    @GetMapping("/getResultByDoctor/{id}")
    public ResponseEntity<String> getResultByDoctor(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByDoctor(id)), HttpStatus.OK);
    }

    @GetMapping("/getResultByAnalysis/{id}")
    public ResponseEntity<String> getResultByAnalysis(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByAnalysis(id)), HttpStatus.OK);
    }

    @GetMapping("/getResultByService/{id}")
    public ResponseEntity<String> getResultByService(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByService(id)), HttpStatus.OK);
    }

    @GetMapping("/getResultById/{id}")
    public ResponseEntity<String> getResultByID(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/deleteResult/{id}")
    public ResponseEntity<String> deleteResultByID(@PathVariable long id){
        resultService.remove(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @PostMapping("/updateResult/{id}")
    public ResponseEntity<String> updateResult(@PathVariable long id, @RequestBody DescribeUpdateAnalysisSvcResult dto){
        resultService.update(id, dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);

    }
}
