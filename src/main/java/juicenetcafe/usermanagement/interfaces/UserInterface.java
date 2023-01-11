package juicenetcafe.usermanagement.interfaces;

import juicenetcafe.usermanagement.entities.User;

import java.util.List;

public interface UserInterface {
    List<User> index();

    User create(User user);

    void assignRoleToUser(String username, String roleName);

    User details(String username);
}
