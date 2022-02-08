package com.medclinic.controller;

import com.medclinic.dto.*;
import com.medclinic.entity.Analysis;
import com.medclinic.entity.AnalysisServiceResult;
import com.medclinic.service.IAnalysisService;
import com.medclinic.service.IAnalysisSvcResultService;
import com.medclinic.service.IMedicalSvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping(value = "/results")
public class ResultController {

    @Autowired
    private IAnalysisService analysisService;

    @Autowired
    private IAnalysisSvcResultService resultService;

    @Autowired
    private IMedicalSvcService medicalSvcService;

    @PutMapping("/analysis/")
    public ResponseEntity<String> createNewAnalysis(@RequestBody @Validated DescribeAnalysisDto dto){
        return ResponseEntity.ok("success! id:"+analysisService.createAnalysis(dto).getId());
    }

    @PutMapping("/analysis/{id}")
    public ResponseEntity<Analysis> updateAnalysis(@PathVariable long id, @RequestBody @Validated DescribeAnalysisDto dto) {
        return ResponseEntity.ok(analysisService.updateAnalysis(dto, id));
    }

    @GetMapping("/analysis/{id}")
    public ResponseEntity<Analysis> getAnalysisById(@PathVariable long id){
        return ResponseEntity.ok(analysisService.findAnalysisByID(id));
    }

    @GetMapping("/analysis/{name}")
    public ResponseEntity<Analysis> getAnalysisByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(analysisService.findByAnalysisByName(name));
    }

    @DeleteMapping("/analysis/{id}")
    public ResponseEntity<String> deleteAnalysisById(@PathVariable long id){
        analysisService.deleteAnalysis(id);
        return ResponseEntity.ok("success!");
    }

    //TODO Возможно следуюет поменять название контроллера
    @PostMapping("/analysis/{analysisID}/")
    public ResponseEntity<String> createResultByAnalysis(@PathVariable long analysisId, @RequestBody @Validated ResultByAnalysisDto dto){
        return ResponseEntity.ok(analysisService.createResultByAnalysis(analysisId, dto).getTitle());
    }

    @GetMapping("/analysis")
    public ResponseEntity<List<Analysis>> getAllAnalysis() {
        return ResponseEntity.ok(analysisService.findAllAnalysis());
    }

    @GetMapping("/res/{doctorId}")
    public ResponseEntity<List<AnalysisServiceResult>> getResultsByDoctor(@PathVariable long doctorId) {
        return ResponseEntity.ok(resultService.findByDoctor(doctorId));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<AnalysisServiceResult>> getResultByClient(@PathVariable long clientId) {
        return ResponseEntity.ok(resultService.findByClient(clientId));
    }

    @GetMapping("/res/{analysisId}")
    public ResponseEntity<List<AnalysisServiceResult>> getResultByAnalysisId(@PathVariable long analysisId) {
        return ResponseEntity.ok(resultService.findByAnalysis(analysisId));
    }

    @GetMapping("/notpaid")
    public ResponseEntity<List<AnalysisServiceResult>> getNotPaidResults() {
        return ResponseEntity.ok(resultService.findByNotPaid());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalysisServiceResult> getResultById(@PathVariable long id) {
        return ResponseEntity.ok(resultService.findById(id));
    }

    @PostMapping("/{resultId}")
    public ResponseEntity<String> updateResult(@PathVariable long resultId, @RequestBody @Validated DescribeUpdateAnalysisSvcResult dto){
        resultService.update(resultId, dto);
        return ResponseEntity.ok("success!");
    }

    @PostMapping("/{analysisId}/createByAnalysis")
    public ResponseEntity<String> createResultByAnalysis(@PathVariable long analysisId, @RequestBody @Validated CreateResultDto dto) {
        return ResponseEntity.ok(resultService.createResultByAnalysis(analysisId, dto).getTitle());
    }

    @PostMapping("/{serviceId}/createByService")
    public ResponseEntity<String> createResultByService(@PathVariable long serviceId, @RequestBody @Validated CreateResultDto dto) {
        return ResponseEntity.ok(resultService.createResultByMedService(serviceId, dto).getTitle());
    }

}
