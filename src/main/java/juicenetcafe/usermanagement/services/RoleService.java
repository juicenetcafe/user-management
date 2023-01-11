package juicenetcafe.usermanagement.services;

import juicenetcafe.usermanagement.entities.Role;
import juicenetcafe.usermanagement.interfaces.RoleInterface;
import juicenetcafe.usermanagement.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService implements RoleInterface {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> index() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(@NotNull Role role) {
        return roleRepository.save(role);
    }
}
