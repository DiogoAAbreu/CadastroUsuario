package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public String createTask(){return "Task created.";}

    @GetMapping("/task")
    public List<TaskModel> getTasks(){return taskService.getTasks();}

    @GetMapping("/task/{id}")
    public TaskModel getTaskById(@PathVariable Long id){return taskService.getTaskById(id);}

    @PutMapping("/task/:id")
    public String alterTaskById(){return "Task updated.";}

    @DeleteMapping("/task/:id")
    public String deleteTaskById(){return "Task deleted.";}
}
