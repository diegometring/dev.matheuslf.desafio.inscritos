package dev.matheuslf.desafio.inscritos.dto.Task;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TaskRequestDTO(
                            @Size(min = 5, max = 100 )
                            String title,
                            String description,
                            Enumerated Status,
                            Enumerated Priority,
                            LocalDateTime dueDate,
                            Long projectId
) {
}
