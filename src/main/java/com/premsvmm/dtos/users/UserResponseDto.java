package com.premsvmm.dtos.users;

import lombok.Data;

@Data
public class UserResponseDto extends UserBaseDTO {
    private int code;
    private String type;
    private String message;
}
