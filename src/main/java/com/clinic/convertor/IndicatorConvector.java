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

    public IndicatorEntity getEntityFromDto(IndicatorDTO dto){
        return new IndicatorEntity(0, dto.getName(), dto.getThreshold());
    }
    public IndicatorEntity copyEntityToEntity(IndicatorEntity entity){
        return new IndicatorEntity(entity.getIndicatorId(), entity.getName(), entity.getThreshold());
    }
}
