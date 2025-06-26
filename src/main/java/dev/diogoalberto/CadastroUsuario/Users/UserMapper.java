package dev.diogoalberto.CadastroUsuario.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();

        userModel.setId(userDTO.getId());
        userModel.setAge(userDTO.getAge());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setSeniority(userDTO.getSeniority());
        userModel.setTask(userDTO.getTask());

        return userModel;
    }

    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userModel.getId());
        userDTO.setAge(userModel.getAge());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setSeniority(userModel.getSeniority());
        userDTO.setTask(userModel.getTask());

        return userDTO;
    }
}
