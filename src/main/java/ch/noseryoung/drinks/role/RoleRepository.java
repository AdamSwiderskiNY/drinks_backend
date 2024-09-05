package ch.noseryoung.drinks.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<ch.noseryoung.drinks.role.Role, Integer> {
    ch.noseryoung.drinks.role.Role findByName(String name);
}

