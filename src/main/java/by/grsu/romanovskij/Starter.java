package by.grsu.romanovskij;

import by.grsu.romanovskij.model.Brigade;
import by.grsu.romanovskij.model.Place;
import by.grsu.romanovskij.model.Role;
import by.grsu.romanovskij.model.User;
import by.grsu.romanovskij.repository.BrigadeRepository;
import by.grsu.romanovskij.repository.PlaceRepository;
import by.grsu.romanovskij.repository.RoleRepository;
import by.grsu.romanovskij.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class Starter {
	private static final Logger logger = Logger.getLogger(Starter.class);

	public static void main(String[] args) {
		SpringApplication.run(Starter.class);
	}

//	@Bean
//	public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleRepository,
//								  PlaceRepository placeRepository, BrigadeRepository brigadeRepository,
//								  BCryptPasswordEncoder passwordEncoder) {
//		return (args) -> {
//			if (roleRepository.findRoleByRoleName("ROLE_ADMIN") == null)
//				roleRepository.save(new Role("ROLE_ADMIN"));
//			if (roleRepository.findRoleByRoleName("ROLE_MANAGER") == null)
//				roleRepository.save(new Role("ROLE_MANAGER"));
//			if (roleRepository.findRoleByRoleName("ROLE_USER") == null)
//				roleRepository.save(new Role("ROLE_USER"));
//
//			if (userRepository.findByUserEmail("admin_1@al.by") == null)
//				userRepository.save(new User("Лёха", "Администерский", "admin_1@al.by",
//					passwordEncoder.encode("111")));
//			if (userRepository.findByUserEmail("manager_1@al.by") == null)
//				userRepository.save(new User("Михаил", "Манагеров", "manager_1@al.by",
//					passwordEncoder.encode("111")));
//			if (userRepository.findByUserEmail("client_1@al.by") == null)
//				userRepository.save(new User("Георгий", "Клиентович", "client_1@al.by",
//					passwordEncoder.encode("111")));
//
//			if (placeRepository.findByPlaceAbbreviation("BY") == null)
//				placeRepository.save(new Place("BY", "Belarus"));
//			if (placeRepository.findByPlaceAbbreviation("UA") == null)
//				placeRepository.save(new Place("UA", "Ukraine"));
//			if (placeRepository.findByPlaceAbbreviation("RU") == null)
//				placeRepository.save(new Place("RU", "Russia"));
//			if (placeRepository.findByPlaceAbbreviation("TC") == null)
//				placeRepository.save(new Place("TC", "Republic of Turkey"));
//
//			if (brigadeRepository.findBrigadeByBrigadeNumber("Without Brigade") == null)
//				brigadeRepository.save(new Brigade("Without Brigade"));
//		};
//	}
}
