package in.strikes.practicalSpringSecurityDemo.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.strikes.practicalSpringSecurityDemo.dto.UserRequestDto;
import in.strikes.practicalSpringSecurityDemo.dto.UserResponseDto;
import in.strikes.practicalSpringSecurityDemo.entity.Role;
import in.strikes.practicalSpringSecurityDemo.entity.User;
import in.strikes.practicalSpringSecurityDemo.repository.RoleRepository;
import in.strikes.practicalSpringSecurityDemo.repository.UserRepository;

@Service 
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder() ;
    public AuthService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    public UserResponseDto register(UserRequestDto userreq){

        User user= new User();
        user.setUsername(userreq.getUsername());
        String password= passwordEncoder.encode(userreq.getPassword());

        user.setPassword(password);
        user.setEnabled(true);
        
        Role role= roleRepository.findByname("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserResponseDto responseuser= new UserResponseDto();
        responseuser.setName(userreq.getUsername());
        responseuser.setMessage("User Registered");
        return responseuser;
    }


    
}
