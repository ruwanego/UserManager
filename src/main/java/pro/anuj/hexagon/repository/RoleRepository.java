package pro.anuj.hexagon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.anuj.hexagon.domain.Role;

/**
 * Role repository
 * 
 * @author Anuj
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);

	Role findById(Long id);
}
