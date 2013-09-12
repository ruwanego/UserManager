package pro.anuj.hexagon.helper;

import org.springframework.stereotype.Component;

import pro.anuj.hexagon.domain.Role;
import pro.anuj.hexagon.support.ValueGenerator;

/**
 * Role Helper 
 * 
 * @author Anuj
 *
 */
@Component
public class RoleHelper implements EntityHelper<Role> {

    @Override
    public Role createEntityInstance() {
        return new Role();
    }

    @Override
    public Role createRandomEntity() {
        Role entity = new Role();
        entity.setRoleName(ValueGenerator.getUniqueString(10));
        return entity;
    }

    @Override
    public Role copyFrom(Role entity) {
        Role copy = new Role();
        copy.setId(entity.getId());
        copy.setRoleName(entity.getRoleName());
        return copy;
    }

    @Override
    public Role copyWithoutPkFrom(Role entity) {
        Role copy = new Role();
        copy.setRoleName(entity.getRoleName());
        return copy;
    }

    @Override
    public Role updateFrom(Role fromentity, Role toEntity) {
        toEntity.setRoleName(fromentity.getRoleName());
        return toEntity;
    }
}
