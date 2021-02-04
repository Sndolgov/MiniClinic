package com.clinic.service;

import com.clinic.convertor.IndicatorConvector;
import com.clinic.dto.IndicatorDTO;
import com.clinic.entity.IndicatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalysisServiceImpl implements AnalysisService
{
    @Autowired
    private IndicatorService indicatorService;
    @Autowired
    private IndicatorConvector indicatorConvector;

    @Override
    public String analyze(IndicatorDTO indicator)
    {
        Map<Integer, IndicatorEntity> indicatorsMap = indicatorService.getIndicatorsMap();
        IndicatorEntity indicatorByName = findIndicatorByName(indicatorsMap.values(), indicator);
        if (indicatorByName == null)
            throw new RuntimeException("There is no indicator with this name: " + indicator.getName());
        return String.format("%s : %s", indicatorsMap.get(indicatorByName.getIndicatorId()).getName()
                , indicator.getThreshold()> indicatorByName.getThreshold()? "Bad!": "Good!");
    }

    private IndicatorEntity findIndicatorByName(Collection<IndicatorEntity> indicatorsList, IndicatorDTO indicator)
    {
        if (indicatorsList == null || indicator == null)
            return null;
        Map<IndicatorEntity, Integer> map = indicatorsList.stream().map(i ->
        {
            IndicatorEntity copy = indicatorConvector.copyEntityToEntity(i);
            String name = copy.getName().toLowerCase();
            name = name.replaceAll("[^a-zA-Z0-9]", " ");
            copy.setName(name);
            return copy;
        }).collect(Collectors.toMap(i -> i, i -> 0));

        String name = indicator.getName();
        String[] words = name.toLowerCase().replaceAll("[^a-zA-Z0-9]", " ").split(" ");

        return findMostSutibleIndicator(words, map);
    }

    private IndicatorEntity findMostSutibleIndicator(String[] words, Map<IndicatorEntity, Integer> map)
    {
        int maxValue = 0;

        for (String word : words)
        {
            if (!word.isEmpty())
            {
                for (Map.Entry<IndicatorEntity, Integer> entry : map.entrySet())
                {
                    if (entry.getKey().getName().contains(word))
                    {
                        int value = entry.getValue() + 1;
                        entry.setValue(value);
                        if (maxValue < value)
                            maxValue = value;
                    }
                }
            }
        }
        if (maxValue == 0)
            return null;
        int finalMax =  maxValue;
        return map.entrySet().stream().filter(e-> e.getValue() == finalMax).map(Map.Entry::getKey).findAny().orElse(null);
    }
}
