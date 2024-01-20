package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.entity.RolEntity;
import com.porfolioprojects.APokedex.entity.UserRolEntity;
import com.porfolioprojects.APokedex.model.RolModel;
import com.porfolioprojects.APokedex.model.UserRolModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    @Mappings({
            @Mapping(source = "rolId", target = "rolId"),
            @Mapping(source = "rol", target = "rol"),
    })
    RolModel toUserRolModel(RolEntity userRolEntity);
    List<UserRolModel> toUserModels(List<UserRolEntity> userRolEntities);

    @Mappings({
            @Mapping(target = "users", ignore = true)
    })
    @InheritInverseConfiguration
    RolEntity toRolEntity(RolModel rolModel);
}
