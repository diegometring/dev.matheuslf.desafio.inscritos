package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.Repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.Repository.TaskRepository;
import dev.matheuslf.desafio.inscritos.dto.Task.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.Task.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.projectRepository = projectRepository;
    }

    public TaskResponseDTO create(TaskRequestDTO taskRequestDTO) {
        Project project = this.projectRepository.findById(taskRequestDTO.projectId())
                .orElseThrow(() -> new RuntimeException("Project not found for create Task"));

        Task task = taskMapper.taskRequestDTOToEntityWithProject(taskRequestDTO, project);
        Task saved = taskRepository.save(task);

        return this.taskMapper.entityToTaskResponseDTO(saved);
    }

    public TaskResponseDTO updateStatus(TaskRequestDTO taskRequestDTO, Long id) {
        Task taskFind = this.taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskFind.setStatusTask(taskRequestDTO.statusTask());
        Task saveTask = this.taskRepository.save(taskFind);
        return this.taskMapper.entityToTaskResponseDTO(saveTask);
    }

    public List<TaskResponseDTO> getFromOptionalsFilters(TaskRequestDTO taskRequestDTO) {
        List<Task> task = this.taskRepository.buscarComFiltros(taskRequestDTO.title(), taskRequestDTO.statusTask(), taskRequestDTO.priorityTask());

        return task.stream()
                .map(taskMapper::entityToTaskResponseDTO)
                .toList();
    }

    public void deleteTask(TaskRequestDTO taskRequestDTO, Long id) {
        Task task = this.taskRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Task not found"));
        this.taskRepository.deleteById(id);
    }
}
