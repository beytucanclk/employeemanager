package tech.flap.employeemanager.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.flap.employeemanager.application.dto.LoginResponseDto;
import tech.flap.employeemanager.application.service.UserService;
import tech.flap.employeemanager.domain.model.User;
import tech.flap.employeemanager.presentation.request.LoginRequest;
import tech.flap.employeemanager.presentation.request.RequestUserData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping()

    public ResponseEntity<List<User>> getDataUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RequestUserData request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return ResponseEntity.ok(userService.registerNewUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Kullanıcıyı kimlik doğrula
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            // Eğer kimlik doğrulama başarılıysa, oturum oluşturulur ve oturum ID çerezde saklanır
            return ResponseEntity.ok("Login successful");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
    }



