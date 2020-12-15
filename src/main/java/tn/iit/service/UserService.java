package tn.iit.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tn.iit.entity.User;
import tn.iit.entity.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

