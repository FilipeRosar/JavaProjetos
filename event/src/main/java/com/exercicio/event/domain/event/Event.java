package com.exercicio.event.domain.event;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "event")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "img_url")
    private String imgurl;
    @Column(name = "event_url")
    private String eventUrl;
    @Column(name = "remote")
    private  Boolean remote;
    @Column(name = "date")
    private Date date;
}
