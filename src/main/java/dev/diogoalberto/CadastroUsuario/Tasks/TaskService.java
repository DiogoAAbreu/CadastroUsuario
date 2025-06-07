package dev.diogoalberto.CadastroUsuario.Tasks;

import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> getTasks(){
        return taskRepository.findAll();
    }
}
