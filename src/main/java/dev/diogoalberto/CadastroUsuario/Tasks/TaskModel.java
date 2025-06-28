package dev.diogoalberto.CadastroUsuario.Tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.diogoalberto.CadastroUsuario.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;
    //uma missão terá varios usuários - mostra que task será a chave correspondente a essa entidade
    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<UserModel> users;
}
