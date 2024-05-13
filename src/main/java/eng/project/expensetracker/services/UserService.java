package eng.project.expensetracker.services;

import eng.project.expensetracker.dtos.UserDTO;
import eng.project.expensetracker.mappers.UserMapper;
import eng.project.expensetracker.repos.UserRepo;
import eng.project.expensetracker.requestObjects.CreateUserRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserMapper userMapper;
    UserRepo userRepo;

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(userMapper::toDTO).toList();
    }

    public UserDTO createUser(CreateUserRequest createUserRequest) {
        return userMapper.toDTO(userRepo.save(userMapper.toEntity(createUserRequest)));
    }

}
