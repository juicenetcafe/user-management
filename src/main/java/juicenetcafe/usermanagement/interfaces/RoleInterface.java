package juicenetcafe.usermanagement.interfaces;

import juicenetcafe.usermanagement.entities.Role;

import java.util.List;

public interface RoleInterface {
    List<Role> index();

    Role create(Role role);
}
