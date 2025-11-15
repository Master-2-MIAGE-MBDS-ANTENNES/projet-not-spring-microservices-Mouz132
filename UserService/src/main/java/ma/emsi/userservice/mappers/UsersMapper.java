package ma.emsi.userservice.mappers;

import ma.emsi.userservice.dtos.UsersDTO;
import ma.emsi.userservice.dtos.UsersResponseDTO;
import ma.emsi.userservice.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public Users toEntity(UsersDTO userDTO) {
        if (userDTO == null) return null;
        Users user = new Users();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        return user;
    }

    public UsersResponseDTO toResponseDTO(Users user) {
        if (user == null) return null;
        return new UsersResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
