package by.grsu.romanovskij.service;

import by.grsu.romanovskij.model.User;
import by.grsu.romanovskij.DataTransferObject.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User findByUserEmail(String userEmail);

	User save(UserRegistrationDto registration);
}
