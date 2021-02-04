package com.clinic.convertor;

import com.clinic.dto.IndicatorDTO;
import com.clinic.entity.IndicatorEntity;
import org.springframework.stereotype.Component;

@Component
public class IndicatorConvector
{
    public IndicatorDTO getDtoFromEntity(IndicatorEntity entity){
        return new IndicatorDTO(entity.getName(), entity.getThreshold());
    }
}
