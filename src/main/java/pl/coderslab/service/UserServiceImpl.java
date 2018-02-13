package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.coderslab.entity.Role;
import pl.coderslab.entity.User;
import pl.coderslab.repo.RoleRepo;
import pl.coderslab.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepo userRepository;
	private final RoleRepo roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepo userRepository, RoleRepo roleRepository, BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User findByUserName(String name) {
		return userRepository.findByUsername(name);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByName("ROLE_USER");
		user.setRole(userRole);
		userRepository.save(user);

	}

	
}
