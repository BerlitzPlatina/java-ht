package com.example.rest_service.families.models;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "families")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false/* , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" */)
    @ColumnDefault("CURRENT_TIMESTAMP")
    Date createdAt = new Date();

    @Column(nullable = false/* , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" */)
    @ColumnDefault("CURRENT_TIMESTAMP")
    Date updatedAt = new Date();

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
