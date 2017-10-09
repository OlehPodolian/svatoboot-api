package oleg.podolyan.svatoapiboot.service.impl;

import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.repository.RoleRepository;
import oleg.podolyan.svatoapiboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
