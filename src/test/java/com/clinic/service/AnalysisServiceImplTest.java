package com.clinic.service;

import com.clinic.dto.IndicatorDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalysisServiceImplTest
{
    @Autowired
    private AnalysisService analysisService;

    @Test
    public void testAnalysis(){
        Assertions.assertEquals("HDL Cholesterol : Good!", analysisService.analyze(new IndicatorDTO("Cholesterol - HDL", 39)));
        Assertions.assertEquals("HDL Cholesterol : Bad!", analysisService.analyze(new IndicatorDTO("HDL, Total", 50)));
        Assertions.assertEquals("LDL Cholesterol : Good!", analysisService.analyze(new IndicatorDTO("CHOLESTEROL-LDL calc", 99)));
        Assertions.assertEquals("A1C : Bad!", analysisService.analyze(new IndicatorDTO("HM Hemoglobin - A1C", 12)));
        Assertions.assertThrows(RuntimeException.class, () -> analysisService.analyze(new IndicatorDTO("Triglycerides", 120)));
        Assertions.assertThrows(RuntimeException.class, () -> analysisService.analyze(new IndicatorDTO(null, 120)));
        Assertions.assertThrows(RuntimeException.class, () -> analysisService.analyze(new IndicatorDTO("", 120)));
    }


}