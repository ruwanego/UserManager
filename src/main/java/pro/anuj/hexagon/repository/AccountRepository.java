package pro.anuj.hexagon.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import pro.anuj.hexagon.domain.Account;

/**
 * Account repository
 * 
 * @author Anuj
 * 
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

	Account findByEmail(String email);

	List<Account> findByTeamsTeamName(String teamName);

}
