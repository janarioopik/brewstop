package eu.itcrafters.brewstop.controller.dto;

import lombok.Data;

/**
 * DTO for {@link eu.itcrafters.brewstop.infrastructure.persistence.Category}
 */


    @Data
    public class CategoryDto {
        private Integer id;
        private String name;
    }

