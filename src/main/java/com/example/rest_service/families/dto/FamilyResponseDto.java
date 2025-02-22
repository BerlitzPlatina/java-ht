package com.example.rest_service.families.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.example.rest_service.families.models.Family;

public class FamilyResponseDto {
    private Integer id;
    private String name;

    public FamilyResponseDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static FamilyResponseDto fromEntity(Family family) {
        return new FamilyResponseDto(
                family.getId(),
                family.getName());
    }
}
