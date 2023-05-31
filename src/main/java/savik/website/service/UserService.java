package savik.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import savik.website.entities.Role;
import savik.website.entities.User;
import savik.website.repository.UserRepository;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MailSender mailSender;
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to WebSite. Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(), user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Registration", message);
        }

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if (user == null)
            return false;

        user.setActivationCode(null);
        user.setActive(true);
        userRepo.save(user);

        return true;
    }
}
