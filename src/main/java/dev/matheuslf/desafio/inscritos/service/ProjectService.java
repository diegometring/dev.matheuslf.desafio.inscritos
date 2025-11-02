package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.Repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.dto.Project.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.Project.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.mapper.ProjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public ProjectResponseDTO criar(ProjectRequestDTO projectRequestDTO) {
        Project project = this.projectMapper.projectRequestDTOToEntity(projectRequestDTO);
        Project projectSave = projectRepository.save(project);

        return this.projectMapper.entityToProjectResponseDTO(projectSave);
    }

    public Page<ProjectResponseDTO> getAllWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projectPage = projectRepository.findAll(pageable);

        return projectPage.map(projectMapper::entityToProjectResponseDTO);
    }
}
