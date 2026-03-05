package com.market.saas.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "commerces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommerceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ownerId;
    private String name;
    private String description;
    private String category;
    private String address;
    private String status; // ATIVO, SUSPENSO

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt; // Adicionado para suportar o @PreUpdate

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = "ATIVO"; // Define status padrão ao criar
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}