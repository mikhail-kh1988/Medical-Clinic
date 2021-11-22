package com.medclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medclinic.dto.CreateResultDto;
import com.medclinic.dto.DescribeAnalysisDto;
import com.medclinic.dto.DescribeUpdateAnalysisSvcResult;
import com.medclinic.dto.ResultByAnalysisDto;
import com.medclinic.service.IAnalysisService;
import com.medclinic.service.IAnalysisSvcResultService;
import com.medclinic.service.IMedicalSvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IAnalysisService analysisService;

    @Autowired
    private IAnalysisSvcResultService resultService;

    @Autowired
    private IMedicalSvcService medicalSvcService;

    @PostMapping("/analysis/")
    public ResponseEntity<String> createNewAnalysis(@RequestBody DescribeAnalysisDto dto){
        return new ResponseEntity<>("success! id:"+analysisService.createAnalysis(dto).getId(), HttpStatus.OK);
    }

    @PostMapping("/analysis/{id}")
    public ResponseEntity<String> updateAnalysis(@PathVariable long id, @RequestBody DescribeAnalysisDto dto) throws JsonProcessingException {
        return new ResponseEntity<String>(mapper.writeValueAsString(analysisService.updateAnalysis(dto, id)), HttpStatus.OK);
    }

    @GetMapping("/analysis/{id}")
    public ResponseEntity<String> getAnalysisById(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(analysisService.findAnalysisByID(id)), HttpStatus.OK);
    }

    @DeleteMapping("/analysis/{id}")
    public ResponseEntity<String> deleteAnalysisById(@PathVariable long id){
        analysisService.deleteAnalysis(id);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @GetMapping("/analysis/{name}")
    public ResponseEntity<String> getAnalysisByName(@PathVariable String name) throws JsonProcessingException {
        return new ResponseEntity<String>(mapper.writeValueAsString(analysisService.findByAnalysisByName(name)), HttpStatus.OK);
    }

    //TODO Возможно следуюет поменять название контроллера
    @PostMapping("/analysis/{analysisID}/")
    public ResponseEntity<String> createResultByAnalysis(@PathVariable long analysisId, @RequestBody ResultByAnalysisDto dto){
        return new ResponseEntity<>(analysisService.createResultByAnalysis(analysisId, dto).getTitle(), HttpStatus.OK);
    }

    @GetMapping("/analysis")
    public ResponseEntity<String> getAllAnalysis() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(analysisService.findAllAnalysis()), HttpStatus.OK);
    }

    @PostMapping("/service/{serviceId}/")
    public ResponseEntity<String> createResultByService(@PathVariable long serviceId, @RequestBody CreateResultDto dto) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.createResultByMedService(serviceId, dto).getTitle()), HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<String> getResultsByDoctor(@PathVariable long doctorId) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByDoctor(doctorId)), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<String> getResultByClient(@PathVariable long clientId) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByClient(clientId)), HttpStatus.OK);
    }

    @GetMapping("/res/{analysisId}")
    public ResponseEntity<String> getResultByAnalysisId(@PathVariable long analysisId) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByAnalysis(analysisId)), HttpStatus.OK);
    }

    @GetMapping("/notpaid")
    public ResponseEntity<String> getNotPaidResults() throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findByNotPaid()), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> getResultById(@PathVariable long id) throws JsonProcessingException {
        return new ResponseEntity<>(mapper.writeValueAsString(resultService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/{resultId}")
    public ResponseEntity<String> updateResult(@PathVariable long resultId, DescribeUpdateAnalysisSvcResult dto){
        resultService.update(resultId, dto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

}
