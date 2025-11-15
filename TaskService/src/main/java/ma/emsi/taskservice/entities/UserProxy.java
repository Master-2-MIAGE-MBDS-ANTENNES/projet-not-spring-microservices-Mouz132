package ma.emsi.taskservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor @Builder
@AllArgsConstructor
public class UserProxy {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
