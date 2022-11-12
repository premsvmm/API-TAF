package com.premsvmm.controllers;

import lombok.Getter;

public enum Routes {
    v2_POST_CREATE_WITH_ARRAY("/v2/user/createWithArray"),
    v2_PUT_USER("/v2/user/%s"),
    v2_GET_USER("/v2/user/%s"),
    v2_POST_PET("/v2/pet"),
    v2_PUT_PET("/v2/pet"),
    v2_GET_PET("/v2/pet/findByStatus");

    @Getter
    private String path;

    Routes(String path) {
        this.path = path;
    }

    public String PETSTORE(String... args) {
        return Constants.BASE_URL + String.format(this.path, args);
    }

}
