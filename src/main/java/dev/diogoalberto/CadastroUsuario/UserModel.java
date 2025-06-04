package dev.diogoalberto.CadastroUsuario;

import dev.diogoalberto.CadastroUsuario.Tasks.TaskModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
    //muitos usuarios terão uma missão
    @ManyToOne
    @JoinColumn(name = "tasks_id")//usado apra criar uma nova coluna com a chave estrangeira que vem de tasks
    private TaskModel task;

    public UserModel() {
    }

    public UserModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
