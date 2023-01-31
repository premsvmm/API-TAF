package com.premsvmm.dtos.users;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserResponseDto extends UserBaseDTO {
    private int code;
    private String type;
    private String message;
}
