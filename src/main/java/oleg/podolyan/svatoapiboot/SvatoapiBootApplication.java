package oleg.podolyan.svatoapiboot;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.hidden.SecurityUtility;
import oleg.podolyan.svatoapiboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SvatoapiBootApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

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

		Role roleAdmin = new Role();
		roleAdmin.setRoleId(2L);
		roleAdmin.setName("ROLE_ADMIN");

//		userRoles.add(new UserRole(admin, roleAdmin));
//		userRoles.add(new UserRole(admin, roleUser));
//
//		userService.createUser(admin, userRoles);
	}
}
