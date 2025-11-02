package dev.matheuslf.desafio.inscritos.dto.Project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record ProjectRequestDTO(
                                @Size(min = 3, max = 100)
                                @NotBlank
                                String name,


                                String description,
                                Date startDate,
                                Date endDate

) {
}
