package oleg.podolyan.svatoapiboot;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;
import oleg.podolyan.svatoapiboot.hidden.SecurityUtility;
import oleg.podolyan.svatoapiboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SvatoapiBootApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SvatoapiBootApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {
		User user = User.getInstance();
		user.setFirstName("Vova");
		user.setLastName("Boyar");
		user.setUsername("vova");
		user.setPassword(SecurityUtility.passwordEncoder().encode("b"));

		Set<UserRole> userRoles = new HashSet<>();

		Role roleUser = new Role();
		roleUser.setRoleId(1L);
		roleUser.setName("ROLE_USER");

		userRoles.add(new UserRole(user, roleUser));

		userService.createUser(user, userRoles);

		userRoles.clear();

		User admin = User.getInstance();
		admin.setFirstName("Oleg");
		admin.setLastName("Podolyan");
		admin.setUsername("oleg");
		admin.setPassword(SecurityUtility.passwordEncoder().encode("p"));


		Role roleAdmin = new Role();
		roleAdmin.setRoleId(2L);
		roleAdmin.setName("ROLE_ADMIN");

		userRoles.add(new UserRole(admin, roleAdmin));
		userRoles.add(new UserRole(admin, roleUser));

		userService.createUser(admin, userRoles);
	}
}
