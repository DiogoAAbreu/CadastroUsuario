package dev.diogoalberto.CadastroUsuario.Tasks;

import dev.diogoalberto.CadastroUsuario.Users.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDTO> getTasks(){
        List<TaskModel> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id){
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.map(taskMapper::map).orElse(null);
    }

    public TaskDTO createTask(TaskDTO taskDTO){
        TaskModel taskModel = taskMapper.map(taskDTO);
        taskModel = taskRepository.save(taskModel);
        return taskMapper.map(taskModel);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    public TaskDTO alterTaskById(Long id, TaskDTO newTask){
        Optional<TaskModel> task = taskRepository.findById(id);
        if(task.isPresent()){
            TaskModel taskModel = taskMapper.map(newTask);
            taskModel.setId(id);
            taskModel = taskRepository.save(taskModel);
            return taskMapper.map(taskModel);
        }
        return null;
    }
}
