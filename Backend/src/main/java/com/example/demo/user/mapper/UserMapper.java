package com.example.demo.user.mapper;

import com.example.demo.user.domain.UserEntity;
import com.example.demo.user.domain.PortfolioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(source = "sourceProperty", target = "targetProperty")
//    PortfolioResponse userEntityToPortfolioResponse(UserEntity user);
}
