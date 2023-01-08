package juicenetcafe.userservice.interfaces;

import juicenetcafe.userservice.entities.User;

import java.util.List;

public interface UserInterface {
    List<User> index();

    User create(User user);

    User details(String username);
}
