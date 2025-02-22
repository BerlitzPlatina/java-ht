package com.example.rest_service.families.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import com.example.rest_service.families.dto.FamilyResponseDto;
import com.example.rest_service.families.models.Family;
import jakarta.persistence.criteria.Predicate;

public class FamilySpecification {
    public static Specification<Family> filterFamilies(String name, String status,
            String role) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
