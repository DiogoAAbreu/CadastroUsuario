package dev.diogoalberto.CadastroUsuario.Tasks;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;

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
