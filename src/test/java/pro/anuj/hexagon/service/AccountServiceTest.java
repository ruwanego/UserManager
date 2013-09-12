package pro.anuj.hexagon.service;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pro.anuj.hexagon.domain.Account;
import pro.anuj.hexagon.helper.AccountHelper;
import pro.anuj.hexagon.service.crud.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountHelper helper;

    @Test
    public void createTest() {
        Account account = this.accountService.create(helper.createRandomEntity());
        assertTrue(account.getId() != null);
    }

    @Test
    @Ignore
    public void readTest() {
        // TODO
    }

    @Test
    public void updateTest() {
        Account account = this.accountService.create(helper.createRandomEntity());
        Long id = account.getId();
        account.setFirstName("Jane");
        this.accountService.update(account);
        Account updatedAccount = this.accountService.getById(id);
        assertTrue(updatedAccount.getFirstName().equals("Jane"));
    }

    @Test
    public void deleteTest() {
        Account account = this.accountService.create(helper.createRandomEntity());
        Long id = account.getId();
        assertTrue(id != null);
        this.accountService.delete(id);
        assertTrue(this.accountService.getById(id) == null);
    }
}
