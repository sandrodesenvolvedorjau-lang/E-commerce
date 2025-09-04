package br.kodemaster.dscommerce.entities;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", nullable = false, unique = true, updatable = false)
    private UUID uuid;

    // Lifecycle
    @PrePersist
    public void generateUUID(){
        if(this.uuid == null){
            this.uuid = UUID.randomUUID();
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }
}
