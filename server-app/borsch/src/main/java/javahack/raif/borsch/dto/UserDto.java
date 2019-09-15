package javahack.raif.borsch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String inn;
//    куча полей, ненужных для кейса
}
