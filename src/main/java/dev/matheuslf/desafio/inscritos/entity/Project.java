package dev.matheuslf.desafio.inscritos.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Task> task = new HashSet<>();
}
