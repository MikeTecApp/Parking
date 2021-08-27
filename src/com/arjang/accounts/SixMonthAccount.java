package com.arjang.accounts;

import java.util.Date;

public class SixMonthAccount extends Account{
    public SixMonthAccount(int accountId) {
        super(accountId);
    }

    @Override
    public void initAccount(String accountName) {
        super.accountName = accountName;
        super.accountType = "Six months Account";
        super.accountEndDate = new Date();
        accountEndDate.setMonth(new Date().getMonth()+6);

    }

    @Override
    public void addAccountBalance() {
        super.balance=60000.00;
    }
}
