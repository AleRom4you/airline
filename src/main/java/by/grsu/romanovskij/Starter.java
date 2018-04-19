package by.grsu.romanovskij;

import by.grsu.romanovskij.model.EmployeePositions;
import by.grsu.romanovskij.model.Role;
import org.apache.log4j.Logger;
import org.hibernate.mapping.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class Starter implements CommandLineRunner {
	private static final Logger logger = Logger.getLogger(Starter.class);

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		Role admin = new Role("ROLE_ADMIN");
		Role manager = new Role("ROLE_MANAGER");
		Role user = new Role("ROLE_USER");
	}
}
