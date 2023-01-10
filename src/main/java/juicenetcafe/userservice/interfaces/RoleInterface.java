package juicenetcafe.userservice.interfaces;

import juicenetcafe.userservice.entities.Role;

import java.util.List;

public interface RoleInterface {
    List<Role> index();

    Role create(Role role);
}
