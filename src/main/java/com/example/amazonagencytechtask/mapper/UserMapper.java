package com.example.amazonagencytechtask.mapper;

import com.example.amazonagencytechtask.config.MapperConfig;
import com.example.amazonagencytechtask.dto.UserRequestDto;
import com.example.amazonagencytechtask.dto.UserResponseDto;
import com.example.amazonagencytechtask.model.db_collections.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toUserResponse(User user);

    User toUserModel(UserRequestDto requestDto);
}
