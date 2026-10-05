package in.strikes.practicalSpringSecurityDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.practicalSpringSecurityDemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional <Role> findByname(String name);
} 