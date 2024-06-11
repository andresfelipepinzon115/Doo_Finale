package com.doo.ubico.api.controller;

import com.doo.ubico.business.domain.TipoDocumento;
import com.doo.ubico.business.domain.User;
import com.doo.ubico.business.usecase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public ResponseEntity<Optional<User>> getUserById(@RequestParam Integer id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(
			@RequestParam String nombre,
			@RequestParam String email,
			@RequestParam String password
		) {
		
		try {
			User user = userService.registerUser(nombre, email, password);
			return ResponseEntity.ok(user);
			
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String correoElectronico, @RequestParam String password) {
		try {
			User user = userService.loginUser(correoElectronico, password);
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}

}
