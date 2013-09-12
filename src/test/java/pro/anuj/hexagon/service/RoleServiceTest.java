package pro.anuj.hexagon.service;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pro.anuj.hexagon.domain.Role;
import pro.anuj.hexagon.helper.RoleHelper;
import pro.anuj.hexagon.service.crud.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class RoleServiceTest {

    @Autowired
    public RoleHelper helper;

    @Autowired
    public RoleService service;

    @Test
    public void createTest() {
        Role entity = service.create(helper.createRandomEntity());
        assertTrue(entity.getId() != null);
    }

    @Ignore
    @Test
    public void readTest() {
        // TODO
    }

    @Test
    public void updateTest() {
        Role entity = service.create(helper.createRandomEntity());
        Long id = entity.getId();
        entity.setRoleName("ROLE_X");
        service.update(entity);
        Role updatedRole = service.getById(id);
        assertTrue(updatedRole.getRoleName().equals("ROLE_X"));
    }

    @Test
    public void deleteTest() {
        Role entity = service.create(helper.createRandomEntity());
        Long id = entity.getId();
        assertTrue(id != null);
        service.delete(id);
        assertTrue(service.getById(id) == null);
    }
}
