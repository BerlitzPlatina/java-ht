package com.example.rest_service.families.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.example.rest_service.families.models.Family;

public interface FamilyRepository
        extends JpaRepository<Family, Long>, JpaSpecificationExecutor<Family> {

}
