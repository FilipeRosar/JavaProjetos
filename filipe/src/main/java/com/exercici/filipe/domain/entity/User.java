package com.exercici.filipe.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @CreationTimestamp
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    private OffsetDateTime modifiedDate;

    public User() {
    }
    public User( String username, String email, String password, OffsetDateTime createdDate, OffsetDateTime modifiedDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }


    public User(String username, String email, String passwordHash, Instant now, Object modifiedDate) {
    }
}
