package tech.flap.employeemanager.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.flap.employeemanager.application.dto.LoginDto;
import tech.flap.employeemanager.application.dto.LoginResponseDto;
import tech.flap.employeemanager.application.service.UserService;
import tech.flap.employeemanager.domain.model.User;
import tech.flap.employeemanager.infrastructure.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerNewUser(User user) {
        boolean userExists = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExists) {
            throw new RuntimeException("User already exists");
        }

        String encoderPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        return userRepository.save(user);
    }

    @Override
    public LoginResponseDto login(LoginDto loginDto){
        Optional<User> optionalUser = userRepository.findByUsername(loginDto.getUsername());

        if (!optionalUser.isPresent()) {
            return new LoginResponseDto(false);
        }

        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), optionalUser.get().getPassword())) {
            return new LoginResponseDto(false);
        }
        return new LoginResponseDto(true);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found"));
    }
}
