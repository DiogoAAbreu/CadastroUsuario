package dev.diogoalberto.CadastroUsuario.Users;

import dev.diogoalberto.CadastroUsuario.Tasks.TaskModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    private String seniority;

    @ManyToOne//muitos usuarios terão uma missãot
    @JoinColumn(name = "tasks_id")//usado apra criar uma nova coluna com a chave esrangeira que vem de tasks
    private TaskModel task;
}
