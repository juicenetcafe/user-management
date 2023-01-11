package juicenetcafe.usermanagement.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleToUser {
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String username;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String roleName;
}
