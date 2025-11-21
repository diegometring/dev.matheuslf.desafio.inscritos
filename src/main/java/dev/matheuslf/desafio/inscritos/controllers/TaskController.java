package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.dto.Task.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.Task.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO response = taskService.create(taskRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    


}
