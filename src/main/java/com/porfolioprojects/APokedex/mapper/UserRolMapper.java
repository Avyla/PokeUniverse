package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.entity.UserRolEntity;
import com.porfolioprojects.APokedex.model.UserRolModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class, UserMapper.class})
public interface UserRolMapper {

    @Mappings({
            @Mapping(source = "userRolId", target = "userRolId"),
            @Mapping(source = "grantedDate", target = "grantedDate"),
            @Mapping(source = "rol", target = "rol")
    })
    UserRolModel toUserRolModel(UserRolEntity userRolEntity);
    List<UserRolModel> toUserRolModels(List<UserRolEntity> userRolEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "user", ignore = true)
    })
    UserRolEntity toUserRolEntity(UserRolModel userRolModel);

}
