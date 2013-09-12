package pro.anuj.hexagon.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import pro.anuj.hexagon.domain.Role;
import pro.anuj.hexagon.helper.EntityHelper;
import pro.anuj.hexagon.helper.RoleHelper;
import pro.anuj.hexagon.repository.RoleRepository;

/**
 * Role Service
 * 
 * @author Anuj
 *
 */
@Service
public class RoleService extends AbstractCrudService<Role> {

    private RoleRepository repository;

    private RoleHelper helper;

    @Autowired
    public RoleService(RoleRepository repository, RoleHelper helper) {
        this.repository = repository;
        this.helper = helper;
    }

    @Override
    public PagingAndSortingRepository<Role, Long> getRepository() {
        return this.repository;
    }

    @Override
    public EntityHelper<Role> getHelper() {
        return this.helper;
    }

}
