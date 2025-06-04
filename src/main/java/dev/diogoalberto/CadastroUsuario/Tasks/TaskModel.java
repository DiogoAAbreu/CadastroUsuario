package dev.diogoalberto.CadastroUsuario.Tasks;

import dev.diogoalberto.CadastroUsuario.Users.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;
    //uma missão terá varios usuários - mostra que task será a chave correspondente a essa entidade
    @OneToMany(mappedBy = "task")
    private List<UserModel> users;

    public TaskModel() {
    }

    public TaskModel(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
