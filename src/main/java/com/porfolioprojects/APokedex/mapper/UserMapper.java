package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.entity.UserEntity;
import com.porfolioprojects.APokedex.model.UserModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "disabled", target = "disabled"),
            @Mapping(source = "locked", target = "locked"),
            @Mapping(source = "roles", target = "roles"),
    })
    UserModel toUserModel(UserEntity userEntity);
    List<UserModel> toUserModels(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(UserModel userModel);

}
