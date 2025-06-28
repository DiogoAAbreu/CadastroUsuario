package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public ResponseEntity<?> createTask(@RequestBody TaskDTO task){
        TaskDTO taskDTO = taskService.createTask(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskDTO);
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskDTO>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable long id){
        TaskDTO taskDTO = taskService.getTaskById(id);
        if (taskDTO != null){
            return ResponseEntity.ok(taskDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa com ID " + id + " não encontrada...");
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<?> alterTaskById(@PathVariable long id, @RequestBody TaskDTO newTask){
        TaskDTO taskDTO = taskService.getTaskById(id);
        if (taskDTO != null){
            TaskDTO savedTask = taskService.alterTaskById(id, newTask);
            return ResponseEntity.ok(savedTask);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa com ID " + id + " não encontrada...");
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable long id){
        TaskDTO taskDTO = taskService.getTaskById(id);
        if(taskDTO != null){
            taskService.deleteTaskById(id);
            return ResponseEntity.ok("Tarefa com ID " + id + " deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa com ID " + id + " não encontrada...");
    }
}
