package com.example.rest_service.families.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.rest_service.families.dto.FamilyRequestDto;
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

    public Page<FamilyResponseDto> getFamilies(FamilyRequestDto familyRequestDto) {
        Specification<Family> spec = FamilySpecification.filterFamilies(familyRequestDto.getName());
        return familyRepository.findAll(spec, familyRequestDto.getPageable()).map(FamilyResponseDto::fromEntity);
    }

    public Family createFamily(FamilyRequestDto familyRequestDto) {
        Family family = new Family();
        family.setName(familyRequestDto.getName());
        return familyRepository.save(family);
    }
}
