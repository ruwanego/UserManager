package pro.anuj.hexagon.controller;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pro.anuj.hexagon.domain.Account;
import pro.anuj.hexagon.helper.AccountHelper;
import pro.anuj.hexagon.helper.EntityHelper;
import pro.anuj.hexagon.service.crud.AbstractCrudService;
import pro.anuj.hexagon.service.crud.AccountService;
import pro.anuj.hexagon.support.AbstractCrudController;

/**
 * Account CRUD controller
 * 
 * @author Anuj
 * 
 */
@Controller
@RequestMapping("/domain/accounts/")
public class AccountController extends AbstractCrudController<Account> {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountHelper helper;

    @Autowired
    private Validator validator;

    @Override
    protected String getListPageName() {
	return "accountsPage";
    }

    @Override
    protected String getCreatePageName() {
	return "createAccountPage";
    }

    @Override
    protected String getUpdatePageName() {
	return "updateAccountPage";
    }

    @Override
    protected AbstractCrudService<Account> getService() {
	return this.service;
    }

    @Override
    protected EntityHelper<Account> getHelper() {
	return this.helper;
    }

    @Override
    protected Validator getValidator() {
	return this.validator;
    }
}
