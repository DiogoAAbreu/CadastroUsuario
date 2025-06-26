package dev.diogoalberto.CadastroUsuario.Tasks;

import dev.diogoalberto.CadastroUsuario.Users.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String name;
    private String difficulty;
    private List<UserModel> users;
}
