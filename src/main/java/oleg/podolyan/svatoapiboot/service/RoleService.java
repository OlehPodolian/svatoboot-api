package oleg.podolyan.svatoapiboot.service;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.security.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Role save(Role role);

    Role findByName(String roleName);

    List<Role> findAll();

    Set<User> findUsersWithRole(String roleName);
}
