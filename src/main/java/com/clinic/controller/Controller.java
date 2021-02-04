package com.clinic.controller;

import com.clinic.dto.IndicatorDTO;
import com.clinic.dto.IndicatorsListDTO;
import com.clinic.service.AnalysisService;
import com.clinic.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class Controller
{
    @Autowired
    private IndicatorService indicatorService;
    @Autowired
    private AnalysisService analysisService;

    @GetMapping("analysis/{name}/{value}")
    private String getResult(@PathVariable String name, @PathVariable Integer value){
        return analysisService.analyze(new IndicatorDTO(name, value));
    }

    @GetMapping("indicators")
    private IndicatorsListDTO getResult(){
        return indicatorService.getIndicatorsListDto();
    }

    @PostMapping("indicator")
    private String addIndicator(@RequestBody IndicatorDTO indicator){
        indicatorService.addNewIndicator(indicator);
        return "Indicator was saved successfully";
    }
}
