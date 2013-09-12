package pro.anuj.hexagon.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import pro.anuj.hexagon.domain.Account;
import pro.anuj.hexagon.helper.AccountHelper;
import pro.anuj.hexagon.helper.EntityHelper;
import pro.anuj.hexagon.repository.AccountRepository;

/**
 * Account service 
 * 
 * @author Anuj
 *
 */
@Service
public class AccountService extends AbstractCrudService<Account> {

    private AccountRepository repository;

    private AccountHelper helper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountHelper helper) {
        this.repository = accountRepository;
        this.helper = helper;
    }

    @Override
    public PagingAndSortingRepository<Account, Long> getRepository() {
        return this.repository;
    }

    @Override
    public EntityHelper<Account> getHelper() {
        return this.helper;
    }
}
