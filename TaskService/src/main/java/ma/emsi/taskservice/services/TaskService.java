package ma.emsi.taskservice.services;

import ma.emsi.taskservice.dtos.TaskDTO;
import ma.emsi.taskservice.dtos.TaskResponseDTO;

import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(TaskDTO taskDTO);
    TaskResponseDTO getTaskById(Long id);
    List<TaskResponseDTO> getAllTasks();
    List<TaskResponseDTO> getTasksByUserId(Long userId);
    void deleteTask(Long id);
}
