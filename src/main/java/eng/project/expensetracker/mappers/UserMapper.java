package eng.project.expensetracker.mappers;


import eng.project.expensetracker.dtos.UserDTO;
import eng.project.expensetracker.entities.User;
import eng.project.expensetracker.requestObjects.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
    User toEntity(CreateUserRequest createUserRequest);
}
