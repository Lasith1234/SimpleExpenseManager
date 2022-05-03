package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;

import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.exception.InvalidAccountException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.ui.DatabaseIni;

public class PersistantAccountDAO implements AccountDAO {

    private DatabaseIni database;

    public PersistantAccountDAO(DatabaseIni db) {

        this.database=db;
    }

    @Override
    public List<String> getAccountNumbersList() {
        return database.get_account_numbers();
    }

    @Override
    public List<Account> getAccountsList() {
        return database.get_accounts();
    }

    @Override
    public Account getAccount(String accountNo) throws InvalidAccountException {
        return database.get_one_account(accountNo);
    }

    @Override
    public void addAccount(Account account) {
        boolean result = database.add_Account_Record(account);
    }

    @Override
    public void removeAccount(String accountNo) throws InvalidAccountException {
        database.account_remove(accountNo);
    }

    @Override
    public void updateBalance(String accountNo, ExpenseType expenseType, double amount) throws InvalidAccountException {
        database.record_update(accountNo,expenseType,amount);
    }
}
