package com.premsvmm.dtos.pets;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PetsBaseDTO {
    private String id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tags> tags;
    private String status;

    @Data
    public static class Category {
        private Integer id;
        private String name;
    }

    @Data
    public static class Tags {
        private Integer id;
        private String name;
    }

}
