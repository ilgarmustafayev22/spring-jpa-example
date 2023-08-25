package az.atlacademy.springuserapp.model.dto;

import az.atlacademy.springuserapp.model.enums.UserJob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private  int age;
    private UserJob job;
    private String addres;

}
