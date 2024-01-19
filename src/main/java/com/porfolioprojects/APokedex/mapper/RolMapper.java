package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.entity.UserRolEntity;
import com.porfolioprojects.APokedex.model.UserRolModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "rol", target = "rol"),
            @Mapping(source = "grantedDate", target = "grantedDate")
    })
    UserRolModel toUserRolModel(UserRolEntity userRolEntity);
    List<UserRolModel> toUserModels(List<UserRolEntity> userRolEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "user", ignore = true)
    })
    UserRolEntity toUserRolEntity(UserRolModel userRolModel);
}
