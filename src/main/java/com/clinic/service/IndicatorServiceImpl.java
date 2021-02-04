package com.clinic.service;

import com.clinic.convertor.IndicatorConvector;
import com.clinic.dto.IndicatorDTO;
import com.clinic.dto.IndicatorsListDTO;
import com.clinic.entity.IndicatorEntity;
import com.clinic.repository.IndicatorJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndicatorServiceImpl implements IndicatorService
{
    @Autowired
    private IndicatorJpa indicatorJpa;

    @Autowired
    private IndicatorConvector indicatorConvector;

    @Override
    public IndicatorsListDTO getIndicatorsListDto()
    {
        return new IndicatorsListDTO(indicatorJpa.findAll().stream().map(indicatorConvector::getDtoFromEntity).collect(Collectors.toList()));
    }

    @Override
    public Map<Integer, IndicatorEntity> getIndicatorsMap()
    {
        return indicatorJpa.findAll().stream().collect(Collectors.toMap(IndicatorEntity::getIndicatorId, i -> i));
    }

    @Override
    public void addNewIndicator(IndicatorDTO indicator)
    {
        indicatorJpa.save(indicatorConvector.getEntityFromDto(indicator));
    }


}
