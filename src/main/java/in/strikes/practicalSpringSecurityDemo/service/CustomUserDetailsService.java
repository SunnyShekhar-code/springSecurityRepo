package in.strikes.practicalSpringSecurityDemo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.strikes.practicalSpringSecurityDemo.entity.CustomUserDetails;
import in.strikes.practicalSpringSecurityDemo.entity.User;
import in.strikes.practicalSpringSecurityDemo.repository.UserRepository;


@Service 
public class CustomUserDetailsService implements UserDetailsService{
    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       

        User user= userRepository.findByUsername(username)
                                    .orElseThrow(()-> new UsernameNotFoundException("User not Found Exception"));

        return new CustomUserDetails(user);
    }
    
    
}
