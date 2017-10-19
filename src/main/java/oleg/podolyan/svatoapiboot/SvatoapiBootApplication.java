package oleg.podolyan.svatoapiboot;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.enums.RoleType;
import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;
import oleg.podolyan.svatoapiboot.hidden.SecurityUtility;
import oleg.podolyan.svatoapiboot.service.RoleService;
import oleg.podolyan.svatoapiboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SvatoapiBootApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(SvatoapiBootApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

		User admin = User.getInstance();
		admin.setUsername("admin");
		admin.setPassword(SecurityUtility.getAdminPassword());
		admin.setPhone("0676367128");
		admin.setEmail("olegvanich@gmail.com");
		admin.setEnabled(true);
		admin.setPhoneDisplayed(false);
		admin.setDob(LocalDate.of(1980, 11, 12));
		admin.setIconPath("");
		admin.setLocality("Харків, Харківська обл");
		admin.setFullName("Подолян Олег");

		Role roleAdmin = roleService.findByName(RoleType.ROLE_ADMIN.getValue());

		Set<UserRole> userRoles = new HashSet<>(1);
		userRoles.add(new UserRole(admin, roleAdmin));

		userService.save(admin);
	}
}
