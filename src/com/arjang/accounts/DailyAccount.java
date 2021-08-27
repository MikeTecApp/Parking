package com.arjang.accounts;

import java.util.Date;

public class DailyAccount extends Account{


    public DailyAccount(int accountId) {
        super(accountId);
    }
    @Override
    public void initAccount(String accountName) {
        super.accountName = accountName;
        super.accountType = "Daily Account";
        super.accountEndDate = new Date();
    }

    @Override
    public void addAccountBalance() {
        super.balance=0.0;
    }

}
