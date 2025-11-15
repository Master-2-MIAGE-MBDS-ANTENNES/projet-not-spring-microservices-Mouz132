package ma.emsi.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
