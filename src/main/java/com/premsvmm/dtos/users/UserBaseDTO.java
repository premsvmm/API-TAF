package com.premsvmm.dtos.users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserBaseDTO {
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
