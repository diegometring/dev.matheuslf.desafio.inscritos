package dev.matheuslf.desafio.inscritos.dto.Task;

import dev.matheuslf.desafio.inscritos.enums.PriorityTask;
import dev.matheuslf.desafio.inscritos.enums.StatusTask;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TaskRequestDTO(
                            @Size(min = 5, max = 100 )
                            String title,
                            String description,
                            StatusTask statusTask,
                            PriorityTask priorityTask,
                            LocalDateTime dueDate,
                            Long projectId
) {
}
