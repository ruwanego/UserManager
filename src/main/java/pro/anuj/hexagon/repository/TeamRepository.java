package pro.anuj.hexagon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.anuj.hexagon.domain.Team;

/**
 * Team repository
 * 
 * @author Anuj
 *
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
