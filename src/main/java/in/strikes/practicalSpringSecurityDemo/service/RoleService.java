package in.strikes.practicalSpringSecurityDemo.service;

import org.springframework.stereotype.Service;

import in.strikes.practicalSpringSecurityDemo.entity.Role;
import in.strikes.practicalSpringSecurityDemo.repository.RoleRepository;


@Service 
public class RoleService {
    private RoleRepository reolRepository;
    public RoleService(RoleRepository reolRepository){
        this.reolRepository=reolRepository;

    }

    public String addRole(String name){
        Role role= new Role();
        role.setName(name);
        reolRepository.save(role);
        return "Role Saved Successfully";
    }
    
}
