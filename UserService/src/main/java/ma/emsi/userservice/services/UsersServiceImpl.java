package ma.emsi.userservice.services;

import ma.emsi.userservice.dtos.UsersDTO;
import ma.emsi.userservice.dtos.UsersResponseDTO;
import ma.emsi.userservice.entities.Users;
import ma.emsi.userservice.mappers.UsersMapper;
import ma.emsi.userservice.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository userRepository;
    private final UsersMapper userMapper;

    public UsersServiceImpl(UsersRepository userRepository, UsersMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UsersResponseDTO createUser(UsersDTO userDTO) {
        Users user = userMapper.toEntity(userDTO);
        Users savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public UsersResponseDTO getUserById(Long id) {
        Users user = userRepository.findById(id).orElse(null);
        return userMapper.toResponseDTO(user);
    }

    @Override
    public List<UsersResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsersResponseDTO> getUsersByIds(List<Long> ids) {
        return userRepository.findAllById(ids)
                .stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
