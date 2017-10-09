package oleg.podolyan.svatoapiboot.service;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    List<User> findAll();

    User save(User user);

    void delete(User user);

    User createUser(User user, Set<UserRole> userRoles);
}
