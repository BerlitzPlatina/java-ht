package com.example.rest_service.families.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_service.families.dto.FamilyRequestDto;
import com.example.rest_service.families.dto.FamilyResponseDto;
import com.example.rest_service.families.models.Family;
import com.example.rest_service.families.services.FamilyService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/families")
public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping
    public ResponseEntity<Page<FamilyResponseDto>> getFamilies(@ModelAttribute FamilyRequestDto familyRequestDto) {
        return ResponseEntity.ok(familyService.getFamilies(familyRequestDto));
    }

    @PostMapping
    public ResponseEntity<Family> createFamily(@RequestBody FamilyRequestDto familyRequestDto) {
        return ResponseEntity.ok(familyService.createFamily(familyRequestDto));
    }
}
