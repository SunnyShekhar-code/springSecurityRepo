package in.strikes.practicalSpringSecurityDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.practicalSpringSecurityDemo.dto.RoleRequestDto;
import in.strikes.practicalSpringSecurityDemo.service.RoleService;


@RestController 
@RequestMapping ("/role")
public class RoleController {

    private RoleService roleService;
    public RoleController(RoleService roleService){
        this.roleService= roleService;
    }

    
    @PostMapping ("/addrole")
    public ResponseEntity<String> addRole(@RequestBody RoleRequestDto role){
        
        String response= roleService.addRole(role.getName());

        return ResponseEntity.ok(response);
    }


    
}
