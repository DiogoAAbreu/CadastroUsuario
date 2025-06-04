package dev.diogoalberto.CadastroUsuario.Tasks;

import dev.diogoalberto.CadastroUsuario.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;
    //uma missão terá varios usuários - mostra que task será a chave correspondente a essa entidade
    @OneToMany(mappedBy = "task")
    private List<UserModel> users;
}
