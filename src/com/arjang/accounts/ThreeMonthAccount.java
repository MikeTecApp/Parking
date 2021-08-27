package com.arjang.accounts;

import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class ThreeMonthAccount extends Account{
    public ThreeMonthAccount(int accountId) {
        super(accountId);
    }

    @Override
    public void initAccount(String accountName) {
        super.accountName = accountName;
        super.accountType = "Three months Account";
        super.accountEndDate = new Date();
        accountEndDate.setMonth(new Date().getMonth()+3);

    }

    @Override
    public void addAccountBalance() {
            super.balance=30000.00;
    }
}
