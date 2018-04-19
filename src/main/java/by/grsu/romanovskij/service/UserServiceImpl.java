package by.grsu.romanovskij.service;

import by.grsu.romanovskij.model.Role;
import by.grsu.romanovskij.model.User;
import by.grsu.romanovskij.repository.UserRepository;
import by.grsu.romanovskij.DataTransferObject.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public User findByUserEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	public User save(UserRegistrationDto registration) {
		User user = new User();
		user.setUserFirstName(registration.getUserFirstName());
		user.setUserLastName(registration.getUserLastName());
		user.setUserEmail(registration.getUserEmail());
		user.setUserPassword(passwordEncoder.encode(registration.getUserPassword()));
		user.setUserRoles(Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUserEmail(userEmail);
		if (user == null) {
			throw new UsernameNotFoundException("Неверное имя пользователя или пароль");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(),
				user.getUserPassword(),
				mapRolesToAuthorities(user.getUserRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> user_roles) {
		return user_roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());
	}
}
