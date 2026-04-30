package com.livraria.books_on.domain.entity;


<<<<<<< Updated upstream
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

=======
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Entity
>>>>>>> Stashed changes
@Table(name = "tb_author")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
<<<<<<< Updated upstream
    private String name;

=======

    private String name;
    @OneToMany(mappedBy = "author")
    private List<Books> books;
>>>>>>> Stashed changes
}
