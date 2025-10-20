package dev.matheuslf.desafio.inscritos.entity;

import dev.matheuslf.desafio.inscritos.enums.priority;
import dev.matheuslf.desafio.inscritos.enums.statusTask;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private statusTask Status;

    @Enumerated(EnumType.STRING)
    private priority Enum;

    private Date dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


}
