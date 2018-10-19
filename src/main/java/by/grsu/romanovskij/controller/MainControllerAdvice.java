package by.grsu.romanovskij.controller;

import by.grsu.romanovskij.model.Role;
import by.grsu.romanovskij.model.User;
import by.grsu.romanovskij.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@ControllerAdvice
public class MainControllerAdvice {
	private static final Logger logger = Logger.getLogger(MainControllerAdvice.class);

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public void addBugetToModel(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		if (!username.equals("anonymousUser")) {
			User user = userRepository.findByUserEmail(username);
			Role role = (Role) user.getUserRoles().toArray()[0];

			model.addAttribute("account", user);
			model.addAttribute("role", role);
			model.addAttribute("authorized", true);
		} else {
			model.addAttribute("authorized", false);
		}
	}

	@RequestMapping(value = "/robots.txt")
	public void robots(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().write("User-agent: *\nDisallow: /\n");
		} catch (IOException e) {
			logger.info("robots(): " + e.getMessage());
		}
	}
}
