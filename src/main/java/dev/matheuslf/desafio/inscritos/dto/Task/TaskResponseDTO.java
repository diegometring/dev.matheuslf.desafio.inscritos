package dev.matheuslf.desafio.inscritos.dto.Task;

import dev.matheuslf.desafio.inscritos.enums.PriorityTask;
import dev.matheuslf.desafio.inscritos.enums.StatusTask;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        String title,
        String description,
        StatusTask statusTask,
        PriorityTask priorityTask,
        LocalDateTime dueDate,
        Long projectId
) {
}
