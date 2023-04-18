package com.example.jpauserrole.services;

import com.example.jpauserrole.entities.Role;
import com.example.jpauserrole.entities.User;
import com.example.jpauserrole.repositories.RoleRepository;
import com.example.jpauserrole.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	@Override
	public User addNewUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public Role addNewRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		User user = findUserByUserName(userName);
		Role role = findRoleByRoleName(roleName);
		if (user.getRoles()!=null)
			user.getRoles().add(role);
			role.getUsers().add(user);
		// userRepository.save(user);
	}

	@Override
	public User authenticate(String userName, String passWord) {
		User user = findUserByUserName(userName);
		if (user == null) throw new RuntimeException("Bad credentials");
		if (user.getPassWord().equals(passWord)) {
			return user;
		}
		throw new RuntimeException("Bad credentials");
	}
}
