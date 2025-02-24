package com.example.rest_service.families.dto;

import org.springframework.data.domain.Pageable;
import utils.dto.BasePageableRequest;

public class FamilyRequestDto extends BasePageableRequest {
    private String name;

    public FamilyRequestDto() {
    }

    public FamilyRequestDto(String name, Pageable pageable) {
        this.name = name;
        setPageable(pageable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
