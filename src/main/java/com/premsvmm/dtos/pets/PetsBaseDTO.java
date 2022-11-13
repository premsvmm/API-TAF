package com.premsvmm.dtos.pets;

import com.premsvmm.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
@Data
@ToString
public class PetsBaseDTO extends BaseDto {
    private Long id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tags> tags;
    private String status;

    @Data
    @AllArgsConstructor
    public static class Category {
        private Integer id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class Tags {
        private Integer id;
        private String name;
    }

}
