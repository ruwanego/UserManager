package pro.anuj.hexagon.service;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pro.anuj.hexagon.domain.Team;
import pro.anuj.hexagon.helper.TeamHelper;
import pro.anuj.hexagon.service.crud.TeamService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class TeamServiceTest {

    @Autowired
    public TeamHelper helper;

    @Autowired
    public TeamService service;

    @Test
    public void createTest() {
        Team entity = service.create(helper.createRandomEntity());
        assertTrue(entity.getId() != null);
    }

    @Ignore
    @Test
    public void readTest() {
        // TODO
    }

    @Test
    public void updateTest() {
        Team entity = service.create(helper.createRandomEntity());
        Long id = entity.getId();
        entity.setTeamName("Dev Team");
        service.update(entity);
        Team updatedTeam = service.getById(id);
        assertTrue(updatedTeam.getTeamName().equals("Dev Team"));
    }

    @Test
    public void deleteTest() {
        Team entity = service.create(helper.createRandomEntity());
        Long id = entity.getId();
        assertTrue(id != null);
        service.delete(id);
        assertTrue(service.getById(id) == null);
    }
}
