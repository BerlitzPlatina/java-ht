package com.example.rest_service.families.dto;

import java.util.Date;
import org.hibernate.annotations.ColumnDefault;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok auto-generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDto {
    private Integer id;

    private String name;

    private Date createdAt;

    private Date updatedAt;
}
