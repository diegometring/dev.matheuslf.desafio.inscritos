package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dto.Project.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.Project.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponseDTO entityToProjectResponseDTO(Project project);

    Project projectRequestDTOToEntity(ProjectRequestDTO projectRequestDTO);
}
