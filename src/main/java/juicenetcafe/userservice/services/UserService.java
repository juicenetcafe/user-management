package juicenetcafe.userservice.services;

import juicenetcafe.userservice.entities.User;
import juicenetcafe.userservice.interfaces.UserInterface;
import juicenetcafe.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserInterface {
    private final UserRepository userRepository;

    @Override
    public List<User> index() {
        log.info("Fetch all users");
        return userRepository.findAll();
    }

    @Override
    public User create(@NotNull User user) {
        log.info("Store user {} to database", user.getName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    @Override
    public User details(String username) throws ResponseStatusException {
        log.info("Fetch user {}", username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "USER_NOT_FOUND"
            );
        }

        return user;
    }
}
