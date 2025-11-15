package ma.emsi.taskservice.services;

import ma.emsi.taskservice.clients.UsersClient;
import ma.emsi.taskservice.dtos.TaskDTO;
import ma.emsi.taskservice.dtos.TaskResponseDTO;
import ma.emsi.taskservice.entities.Task;
import ma.emsi.taskservice.mappers.TaskMapper;
import ma.emsi.taskservice.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UsersClient usersClient;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UsersClient usersClient) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.usersClient = usersClient;
    }

    @Override
    public TaskResponseDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toResponseDTO(savedTask);
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setUsers(usersClient.getUsersByIds(task.getAssignedUserIds()));
        }
        return taskMapper.toResponseDTO(task);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskResponseDTO> getTasksByUserId(Long userId) {
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getAssignedUserIds() != null && task.getAssignedUserIds().contains(userId))
                .map(taskMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
