package in.strikes.practicalSpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.strikes.practicalSpringSecurityDemo.service.CustomUserDetailsService;

@Configuration 
public class SecurityConfig {

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public AuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder, CustomUserDetailsService CustomUserDetailsService){
        
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider(CustomUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,DaoAuthenticationProvider daoAuthenticationProvider){

        httpSecurity.csrf(csrf -> csrf.disable())
                    .authenticationProvider(daoAuthenticationProvider)
                    .formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults())
                    .authorizeHttpRequests(auth -> 
                        auth.requestMatchers("/api/users/register" , "/role/addrole").permitAll()
                            .anyRequest().authenticated()
                    );

                    return httpSecurity.build();
    }
    
}
