package eng.project.expensetracker;

import eng.project.expensetracker.entities.User;
import eng.project.expensetracker.mappers.UserMapper;
import eng.project.expensetracker.repos.UserRepo;
import eng.project.expensetracker.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepo userRepo;
    @Mock
    UserMapper userMapper;

    @Test
    void getAllUsers() {
        User user1 = new User(null, "John Doe", "john.doe@mail.com", "pass", null, null);
        User user2 = new User(null, "Jane Doe", "jane.doe@mail.com", "pass", null, null);
        Mockito.when(userRepo.findAll()).thenReturn(List.of(user1, user2));
        Assertions.assertEquals(2, userService.getAllUsers().size());
    }

}
