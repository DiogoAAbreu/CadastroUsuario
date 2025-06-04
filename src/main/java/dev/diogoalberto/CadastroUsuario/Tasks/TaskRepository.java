package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long>{
}
