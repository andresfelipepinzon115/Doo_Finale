package com.doo.ubico.Interface;

import java.util.Optional;

import com.doo.ubico.business.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    Optional<User> getUserById(Integer userID);

    User save(User user);

    User findByCorreoElectronico(String correoElectronico);

}
