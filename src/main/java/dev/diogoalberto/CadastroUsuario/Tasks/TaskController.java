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
    public TaskDTO createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }

    @GetMapping("/task")
    public List<TaskDTO> getTasks(){return taskService.getTasks();}

    @GetMapping("/task/{id}")
    public TaskDTO getTaskById(@PathVariable long id){return taskService.getTaskById(id);}

    @PutMapping("/task/{id}")
    public TaskDTO alterTaskById(@PathVariable long id, @RequestBody TaskDTO newTask){
        return taskService.alterTaskById(id, newTask);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTaskById(@PathVariable long id){
        taskService.deleteTaskById(id);
    }
}
