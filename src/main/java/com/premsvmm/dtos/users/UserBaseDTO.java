package com.premsvmm.dtos.users;

import com.google.gson.annotations.SerializedName;
import com.premsvmm.dtos.BaseDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserBaseDTO extends BaseDto {
    private Integer id;
    @SerializedName("username")
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;
}
