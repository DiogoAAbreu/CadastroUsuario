package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TaskController {
    @PostMapping("/task")
    public String createTask(){return "Task created.";}

    @GetMapping("/task")
    public String getTasks(){return "Tasks found.";}

    @GetMapping("/task/:id")
    public String getTaskById(){return "Task found.";}

    @PutMapping("/task/:id")
    public String alterTaskById(){return "Task updated.";}

    @DeleteMapping("/task")
    public String deleteTaskById(){return "Task deleted.";}
}
