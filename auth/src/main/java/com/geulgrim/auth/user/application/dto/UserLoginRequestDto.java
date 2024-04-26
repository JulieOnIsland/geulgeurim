package com.geulgrim.auth.user.application.dto;

import com.geulgrim.auth.user.domain.UserType;
import lombok.Getter;

@Getter
public class UserLoginRequestDto {

    private String password;
    private String email;
}
