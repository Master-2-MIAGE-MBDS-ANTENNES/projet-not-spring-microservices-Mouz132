package ma.emsi.userservice.services;

import ma.emsi.userservice.dtos.UsersDTO;
import ma.emsi.userservice.dtos.UsersResponseDTO;

import java.util.List;

public interface UsersService {
    UsersResponseDTO createUser(UsersDTO userDTO);
    UsersResponseDTO getUserById(Long id);
    List<UsersResponseDTO> getAllUsers();
    List<UsersResponseDTO> getUsersByIds(List<Long> ids);
    void deleteUser(Long id);
}
