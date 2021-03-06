package services;

import io.ReadAndWriteAccount;
import models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    List<Account> accounts = ReadAndWriteAccount.readAccount();

    public AccountService() {
    }

    public void addAccount(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName())) {
                return;
            }
        }
        accounts.add(account);
        ReadAndWriteAccount.writeAccount(accounts);
    }

    public List<Account> findAll() {
        return accounts;
    }

    public boolean login(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(Account account) {
        if ("admin".equals(account.getUserName()) && "admin".equals(account.getPassWord())) {
            return true;
        }
        return false;
    }
}
