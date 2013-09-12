package pro.anuj.hexagon.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import pro.anuj.hexagon.domain.Team;
import pro.anuj.hexagon.helper.EntityHelper;
import pro.anuj.hexagon.helper.TeamHelper;
import pro.anuj.hexagon.repository.TeamRepository;

/**
 * Team Service
 * 
 * @author Anuj
 * 
 */
@Service
public class TeamService extends AbstractCrudService<Team> {

	private TeamRepository repository;

	private TeamHelper helper;

	@Autowired
	public TeamService(TeamRepository repository, TeamHelper helper) {
		this.repository = repository;
		this.helper = helper;
	}

	@Override
	public PagingAndSortingRepository<Team, Long> getRepository() {
		return this.repository;
	}

	@Override
	public EntityHelper<Team> getHelper() {
		return this.helper;
	}

}
