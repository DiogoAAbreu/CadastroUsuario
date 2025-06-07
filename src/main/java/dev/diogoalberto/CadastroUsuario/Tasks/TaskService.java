package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> getTasks(){
        return taskRepository.findAll();
    }
}
