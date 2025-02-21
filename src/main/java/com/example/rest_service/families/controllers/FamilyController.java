package com.example.rest_service.families.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<Page<Family>> getFamilies(@RequestParam(required = false) String name,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String role,
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(familyService.getFamilies(name, status, role, pageable));
    }
}
