package pro.anuj.hexagon.controller;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pro.anuj.hexagon.domain.Role;
import pro.anuj.hexagon.helper.EntityHelper;
import pro.anuj.hexagon.helper.RoleHelper;
import pro.anuj.hexagon.service.crud.AbstractCrudService;
import pro.anuj.hexagon.service.crud.RoleService;
import pro.anuj.hexagon.support.AbstractCrudController;

/**
 * Role CRUD Controller
 * 
 * @author Anuj
 * 
 */

@Controller
@RequestMapping("/domain/roles/")
public class RoleController extends AbstractCrudController<Role> {

    @Autowired
    private RoleService service;

    @Autowired
    private RoleHelper helper;

    @Autowired
    private Validator validator;

    @Override
    protected String getListPageName() {
	return "rolesPage";
    }

    @Override
    protected String getCreatePageName() {
	return "createRolePage";
    }

    @Override
    protected String getUpdatePageName() {
	return "updateRolePage";
    }

    @Override
    protected AbstractCrudService<Role> getService() {
	return this.service;
    }

    @Override
    protected EntityHelper<Role> getHelper() {
	return this.helper;
    }

    @Override
    protected Validator getValidator() {
	return this.validator;
    }
}
