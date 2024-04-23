package com.geulgrim.common.user.application.dto;

import com.geulgrim.common.user.domain.User;
import com.geulgrim.common.user.domain.UserType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {

    private Long userId;

    private String password;

    private String email;

    private String birthday;

    private String name;

    private String wallet;

    private String phoneNum;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .password(new BCryptPasswordEncoder(16).encode(password))
                .email(email)
                .birthday(birthday)
                .name(name)
                .wallet(wallet)
                .phoneNum(phoneNum)
                .build();
    }
}
