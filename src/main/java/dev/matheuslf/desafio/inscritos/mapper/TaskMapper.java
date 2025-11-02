package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dto.Task.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.Task.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponseDTO entityToTaskResponseDTO(Task task);
    Task taskResponseDTOToEntity(TaskRequestDTO taskRequestDTO, Project project);

}
