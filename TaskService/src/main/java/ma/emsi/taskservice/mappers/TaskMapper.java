package ma.emsi.taskservice.mappers;

import ma.emsi.taskservice.dtos.TaskDTO;
import ma.emsi.taskservice.dtos.TaskResponseDTO;
import ma.emsi.taskservice.entities.Task;
import ma.emsi.taskservice.entities.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskDTO taskDTO) {
        if (taskDTO == null) return null;
        return Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .status(TaskStatus.valueOf(taskDTO.getStatus()))
                .build();
    }

    public TaskResponseDTO toResponseDTO(Task task) {
        if (task == null) return null;
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().toString());
        return dto;
    }
}
