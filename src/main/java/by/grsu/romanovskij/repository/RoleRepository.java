package by.grsu.romanovskij.repository;

import by.grsu.romanovskij.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findRoleByRoleId(int roleId);
    Role findRoleByRoleName(String roleName);
}
