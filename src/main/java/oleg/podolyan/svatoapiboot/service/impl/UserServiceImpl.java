package oleg.podolyan.svatoapiboot.service.impl;

import oleg.podolyan.svatoapiboot.repository.UserRepository;
import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;
import oleg.podolyan.svatoapiboot.service.RoleService;
import oleg.podolyan.svatoapiboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User mUser = userRepository.findByUsername(user.getUsername());
        if (mUser != null){
            logger.info("User with username {} already exists, nothing will happen here", user.getUsername());
        } else {
            userRoles.forEach(userRole -> roleService.save(userRole.getRole()));
            user.getUserRoles().addAll(userRoles);
            mUser = userRepository.save(user);
        }
        return mUser;
    }
}
