package com.livraria.books_on.domain.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
<<<<<<< HEAD

=======
>>>>>>> fda9d4ff272f6b1789688d3e8de223555d402010
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "tb_author")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
<<<<<<< HEAD
    @OneToMany(mappedBy = "author")
    private List<Books> books;
=======

    @OneToMany(mappedBy = "author")
    private List<Books> books;

>>>>>>> fda9d4ff272f6b1789688d3e8de223555d402010
}
