package dev.diogoalberto.CadastroUsuario.Tasks;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskModel map (TaskDTO taskDTO){
        TaskModel taskModel = new TaskModel();

        taskModel.setId(taskDTO.getId());
        taskModel.setName(taskDTO.getName());
        taskModel.setDifficulty(taskDTO.getDifficulty());
        taskModel.setUsers(taskDTO.getUsers());

        return taskModel;
    }

    public TaskDTO map (TaskModel taskModel){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(taskModel.getId());
        taskDTO.setName(taskModel.getName());
        taskDTO.setDifficulty(taskModel.getDifficulty());
        taskDTO.setUsers(taskModel.getUsers());

        return taskDTO;
    }
}
