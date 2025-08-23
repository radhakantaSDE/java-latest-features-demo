package com.learn.app.patterns.structural;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserEntity {
    private Integer id;
    private String username;
    private String name;
    private String email;
    private String passwordHash;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserDTO {
    private String name;
    private String email;
}

// Adapter interface
interface UserAdapter {
    UserDTO convertToDTO(UserEntity userEntity);
}

// Concrete Adapter implementation
class UserEntityToDTOAdapter implements UserAdapter {
    @Override
    public UserDTO convertToDTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new UserDTO(userEntity.getName(), userEntity.getEmail());
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity(100, "john", "John Doe", "john@gmail.com", "hashed_password");
        UserAdapter userAdapter = new UserEntityToDTOAdapter();
        UserDTO userDTO = userAdapter.convertToDTO(userEntity);
        System.out.println("UserDTO: " + userDTO);
    }
}
