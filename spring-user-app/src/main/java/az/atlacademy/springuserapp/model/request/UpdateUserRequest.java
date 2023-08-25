package az.atlacademy.springuserapp.model.request;

import az.atlacademy.springuserapp.model.enums.UserJob;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    @NotBlank
    private String name;

    @Min(18)
    private Integer age;

    @NotNull
    private UserJob job;

    @NotNull
    private String addres;

}
