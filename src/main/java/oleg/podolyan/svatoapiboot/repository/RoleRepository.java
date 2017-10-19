package oleg.podolyan.svatoapiboot.repository;

import oleg.podolyan.svatoapiboot.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role save(Role role);

    Role findByName(String roleName);

    List<Role> findAll();
}
