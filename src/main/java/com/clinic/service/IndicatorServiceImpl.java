package com.clinic.service;

import com.clinic.convertor.IndicatorConvector;
import com.clinic.dto.IndicatorsListDTO;
import com.clinic.repository.IndicatorJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class IndicatorServiceImpl implements IndicatorService
{
    @Autowired
    private IndicatorJpa indicatorJpa;

    @Autowired
    private IndicatorConvector indicatorConvector;

    @Override
    public IndicatorsListDTO getIndicatorsList()
    {
        return new IndicatorsListDTO(indicatorJpa.findAll().stream().map(indicatorConvector::getDtoFromEntity).collect(Collectors.toList()));
    }
}
