package dev.diogoalberto.CadastroUsuario.Users;

import dev.diogoalberto.CadastroUsuario.Tasks.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String seniority;
    private TaskModel task;
}
