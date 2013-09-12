package pro.anuj.hexagon.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.anuj.hexagon.domain.Account;
import pro.anuj.hexagon.domain.Role;
import pro.anuj.hexagon.domain.Team;
import pro.anuj.hexagon.repository.AccountRepository;
import pro.anuj.hexagon.repository.RoleRepository;
import pro.anuj.hexagon.repository.TeamRepository;

/**
 * Data initialization service
 * 
 * @author Anuj
 * 
 */
@Service("initDataService")
public class InitDataService {

	@Autowired
	AccountRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	TeamRepository teamRepository;

	public void init() {
		/* A user with admin right */
		Role adminRole = getRole("ROLE_ADMIN");
		Role userRole = getRole("ROLE_USER");
		Team devTeam = getTeam("DEV TEAM");
		Team bdTeam = getTeam("BD TEAM");

		Account admin = new Account();
		admin.setFirstName("John");
		admin.setLastName("Doe");
		admin.setEmail("admin@mail.com");
		admin.setPassword(DigestUtils.md5Hex("admin"));
		admin.setIsEnabled(true);
		this.userRepository.save(admin);
		admin.getRoles().add(adminRole);
		admin.getRoles().add(userRole);
		this.userRepository.save(admin);
		admin.getTeams().add(bdTeam);
		admin.getTeams().add(devTeam);
		this.userRepository.save(admin);
		
		/* A user with no admin right */
		Account user = new Account();
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setEmail("user@mail.com");
		user.setPassword(DigestUtils.md5Hex("user"));
		user.setIsEnabled(true);
		this.userRepository.save(user);
		user.getRoles().add(userRole);
		this.userRepository.save(user);

		// add 100 more users without roles (To test pagination)
		List<Account> listUsers = new ArrayList<Account>();
		Account aUser;
		for (int i = 0; i < 100; i++) {
			aUser = new Account();
			aUser.setFirstName("FirstName_" + i);
			aUser.setLastName("LastName_" + i);
			aUser.setEmail("User_" + i + "@mail.com");
			aUser.setPassword(DigestUtils.md5Hex("user"));
			aUser.setIsEnabled(true);
			listUsers.add(aUser);
		}
		this.userRepository.save(listUsers);
	}

	private Role getRole(final String roleName) {
		Role result = roleRepository.findByRoleName(roleName);
		if (result == null) {
			result = new Role();
			result.setRoleName(roleName);
			roleRepository.save(result);
		}
		return result;
	}

	private Team getTeam(final String teamName) {
		Team result = teamRepository.findByTeamName(teamName);
		if (result == null) {
			result = new Team();
			result.setTeamName(teamName);
			teamRepository.save(result);
		}
		return result;
	}
}
