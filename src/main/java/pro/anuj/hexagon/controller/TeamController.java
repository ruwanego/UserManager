package pro.anuj.hexagon.controller;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pro.anuj.hexagon.domain.Team;
import pro.anuj.hexagon.helper.EntityHelper;
import pro.anuj.hexagon.helper.TeamHelper;
import pro.anuj.hexagon.service.crud.AbstractCrudService;
import pro.anuj.hexagon.service.crud.TeamService;
import pro.anuj.hexagon.support.AbstractCrudController;

/**
 * Team CRUD Controller
 * 
 * @author Anuj
 * 
 */

@Controller
@RequestMapping("/domain/teams/")
public class TeamController extends AbstractCrudController<Team> {

    @Autowired
    private TeamService service;

    @Autowired
    private TeamHelper helper;

    @Autowired
    private Validator validator;

    @Override
    protected String getListPageName() {
	return "teamsPage";
    }

    @Override
    protected String getCreatePageName() {
	return "createTeamPage";
    }

    @Override
    protected String getUpdatePageName() {
	return "updateTeamPage";
    }

    @Override
    protected AbstractCrudService<Team> getService() {
	return this.service;
    }

    @Override
    protected EntityHelper<Team> getHelper() {
	return this.helper;
    }

    @Override
    protected Validator getValidator() {
	return this.validator;
    }
}
