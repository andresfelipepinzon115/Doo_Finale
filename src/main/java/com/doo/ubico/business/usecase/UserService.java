package com.doo.ubico.business.usecase;

import com.doo.ubico.Interface.UserRepository;
import com.doo.ubico.business.domain.TipoDocumento;
import com.doo.ubico.business.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Optional<User> getUserById(Integer userID) {
        return userRepository.getUserById(userID);
	}

	public User registerUser(String nombre, String primerApellido, String segundoApellido, String numeroDocumento,
			TipoDocumento tipoDocumento, String correoElectronico, String telefonoMovil, String password) {
		if (userRepository.findByCorreoElectronico(correoElectronico) != null) {
			throw new IllegalArgumentException("Email is already taken.");
		}
		String encodedPassword = passwordEncoder.encode(password);
		User user = new User(null, nombre, primerApellido, segundoApellido, numeroDocumento, tipoDocumento,
				correoElectronico, telefonoMovil, encodedPassword);
		return userRepository.save(user);
	}
	
	public User registerUser(String nombre, String email,String password) {
		if (userRepository.findByCorreoElectronico(email) != null) {
			throw new IllegalArgumentException("Email is already taken.");
		}
		String encodedPassword = passwordEncoder.encode(password);
		User user = new User(null, nombre, email, encodedPassword);
		return userRepository.save(user);
	}

	public User loginUser(String correoElectronico, String password) {
		User user = userRepository.findByCorreoElectronico(correoElectronico);
		if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
			throw new IllegalArgumentException("Invalid email or password.");
		}
		return user;
	}

}
