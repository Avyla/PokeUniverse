package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.StatsAPI;
import com.porfolioprojects.APokedex.dto.pokemon.StatsDTO;
import com.porfolioprojects.APokedex.entity.pokemon.StatsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {StatMapper.class})
public interface StatsMapper {

    @Mappings({
            @Mapping(source = "statsId", target = "statsId"),
            @Mapping(source = "base_stat", target = "baseStat"),
            @Mapping(source = "effort", target = "effort"),
            @Mapping(source = "stat", target = "stat"),
            @Mapping(target = "pokemon", ignore = true)
    })
    StatsEntity toStatsEntity(StatsAPI statsAPI);

    @InheritInverseConfiguration
    StatsAPI toStatsAPI(StatsEntity statsEntity);

    @Mappings({
            @Mapping(source = "baseStat", target = "baseStat"),
            @Mapping(source = "effort", target = "effort"),
            @Mapping(source = "stat", target = "stat")
    })
    StatsDTO toStatsDTO(StatsEntity statsEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "statsId", ignore = true),
            @Mapping(target = "pokemon", ignore = true)
    })
    StatsEntity toStatsEntity(StatsDTO statsDTO);

}
