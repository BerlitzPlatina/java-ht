package com.example.rest_service.families.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.rest_service.families.dto.FamilyResponseDto;
import com.example.rest_service.families.models.Family;
import com.example.rest_service.families.repositores.FamilyRepository;

@Service
public class FamilyService {
    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public Page<FamilyResponseDto> getFamilies(String name, String status, String role,
            Pageable pageable) {
        Specification<Family> spec = FamilySpecification.filterFamilies(name, status, role);
        return familyRepository.findAll(spec, pageable).map(FamilyResponseDto::fromEntity);
    }
}
