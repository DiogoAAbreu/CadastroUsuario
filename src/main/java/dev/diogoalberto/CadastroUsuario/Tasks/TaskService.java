package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> getTasks(){
        return taskRepository.findAll();
    }

    public TaskModel getTaskById(Long id){
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public TaskModel createTask(TaskModel task){
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    public TaskModel alterTaskById(Long id, TaskModel newTask){
        if(taskRepository.existsById(id)){
            newTask.setId(id);
            return taskRepository.save(newTask);
        }
        return null;
    }
}
