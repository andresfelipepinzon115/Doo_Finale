package com.doo.ubico.Interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.doo.ubico.business.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private final Map<String, User> database = new HashMap<>();

	@Override
	public User save(User user) {
		user.setId(String.valueOf(database.size() + 1));
		database.put(user.getCorreoElectronico(), user);
		return user;
	}

	@Override
	public User findByCorreoElectronico(String correoElectronico) {
		return database.get(correoElectronico);
	}

	@Override
	public Optional<User> getUserById(Integer userID) {
		return Optional.ofNullable(database.get(userID));
	}

}
