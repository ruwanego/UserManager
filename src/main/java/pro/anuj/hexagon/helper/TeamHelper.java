package pro.anuj.hexagon.helper;

import org.springframework.stereotype.Component;

import pro.anuj.hexagon.domain.Team;
import pro.anuj.hexagon.support.ValueGenerator;

/**
 * Team Helper 
 * 
 * @author Anuj
 *
 */
@Component
public class TeamHelper implements EntityHelper<Team> {

    @Override
    public Team createEntityInstance() {
        return new Team();
    }

    @Override
    public Team createRandomEntity() {
        Team entity = new Team();
        entity.setTeamName(ValueGenerator.getUniqueString(10));
        return entity;
    }

    @Override
    public Team copyFrom(Team entity) {
        Team copy = new Team();
        copy.setId(entity.getId());
        copy.setTeamName(entity.getTeamName());
        return copy;
    }

    @Override
    public Team copyWithoutPkFrom(Team entity) {
        Team copy = new Team();
        copy.setTeamName(entity.getTeamName());
        return copy;
    }

    @Override
    public Team updateFrom(Team fromentity, Team toEntity) {
        toEntity.setTeamName(fromentity.getTeamName());
        return toEntity;
    }
}
