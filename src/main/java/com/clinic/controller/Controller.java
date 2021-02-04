package com.clinic.controller;

import com.clinic.dto.IndicatorDTO;
import com.clinic.dto.IndicatorsListDTO;
import com.clinic.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class Controller
{
    @Autowired
    private IndicatorService indicatorService;

    @PostMapping("analysis")
    private void getResult(@RequestBody IndicatorsListDTO indicators){
        System.out.println(indicators);
    }

    @GetMapping("indicators")
    private IndicatorsListDTO getResult(){
        return indicatorService.getIndicatorsList();
    }

    @PostMapping("indicator")
    private String addIndicator(@RequestBody IndicatorDTO indicator){
        indicatorService.addNewIndicator(indicator);
        return "Indicator was saved successfully";
    }
}
