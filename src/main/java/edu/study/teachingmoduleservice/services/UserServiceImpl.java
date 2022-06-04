package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.user.Role;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.domain.user.UserAccount;
import edu.study.teachingmoduleservice.repository.UserAccountRepository;
import edu.study.teachingmoduleservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final Float DEFAULT_RATE_VALUE = 0f;
    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;

    public UserServiceImpl(UserRepository userRepository, UserAccountRepository userAccountRepository) {
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
    }


    public User findByEmail(String email){
        return userRepository.getById(email);
    }

    public void saveUser(User user) {
        UserAccount newAccount = new UserAccount();
        newAccount.setUserName(user.getEmail().split("@")[0]);
        newAccount.setRateValue(DEFAULT_RATE_VALUE);
        newAccount.setUser(user);

        user.setRoles(Set.of(Role.STUDENT));
        String password = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setAccount(newAccount);

        userAccountRepository.save(newAccount);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getById(username);
        LOGGER.debug("loadUserByUsername " + username + " returns " + user);
        return user;
    }
}
