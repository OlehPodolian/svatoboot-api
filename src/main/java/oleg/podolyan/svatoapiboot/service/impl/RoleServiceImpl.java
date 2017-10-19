package oleg.podolyan.svatoapiboot.service.impl;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.repository.RoleRepository;
import oleg.podolyan.svatoapiboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByName(String roleName){
        return roleRepository.findByName(roleName);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Set<User> findUsersWithRole(String roleName) {
        Role mRole = findByName(roleName);
        final Set<User> users = new HashSet<>();
        mRole.getUserRoles().forEach(userRole -> users.add(userRole.getUser()));
        return users;
    }
}
