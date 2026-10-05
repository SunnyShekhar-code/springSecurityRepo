package in.strikes.practicalSpringSecurityDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.practicalSpringSecurityDemo.dto.UserRequestDto;
import in.strikes.practicalSpringSecurityDemo.dto.UserResponseDto;
import in.strikes.practicalSpringSecurityDemo.service.AuthService;

@RestController 
@RequestMapping ("/api")
public class UserController {
    private AuthService authService;

    public UserController(AuthService authService){
        this.authService=authService;
    }

    PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @GetMapping ("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");

    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken token){
        return  token;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody  UserRequestDto user){

        UserResponseDto userResponse=authService.register(user);

        return ResponseEntity.ok(userResponse);

    }
    
    
}
