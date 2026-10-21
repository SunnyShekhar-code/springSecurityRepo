package in.strikes.practicalSpringSecurityDemo.repository;

import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.practicalSpringSecurityDemo.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional <User> findByUsername(String username);

    @EntityGraph (attributePaths = "roles")
    Optional <Role> findByUserName(String username);
    
}
