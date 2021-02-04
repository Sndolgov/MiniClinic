package com.clinic.service;

import com.clinic.dto.IndicatorDTO;
import com.clinic.dto.IndicatorsListDTO;
import com.clinic.entity.IndicatorEntity;

import java.util.Map;

public interface IndicatorService
{
    IndicatorsListDTO getIndicatorsListDto();
    Map<Integer, IndicatorEntity> getIndicatorsMap();

    void addNewIndicator(IndicatorDTO indicator);

}
