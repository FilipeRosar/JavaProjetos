package com.exercicio.event.domain.address;

import com.exercicio.event.domain.event.Event;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String street;
    private String city;
    private String uf;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
