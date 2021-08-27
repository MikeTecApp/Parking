package com.arjang.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Account {
    protected int accountId;
    protected String accountName;
    protected String accountType;
    protected Date accountStartDate;
    protected Date accountEndDate;
    protected  double balance;
    SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd");

    public Account(int accountId) {
        this.accountId = accountId;
        this.accountStartDate = new Date();
    }
    public abstract void initAccount(String accountName);
    public abstract void addAccountBalance ();

    @Override
    public String toString() {
        return "\n Account {" +
                 "\n Type = '" + accountType + '\'' +
                ",\n From = '" + dateFormat.format(accountStartDate)  + '\'' +
                ",\n To = '" + dateFormat.format(accountEndDate)  + '\'' +
                ",\n Amount = " + balance +
                 '}';
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public Date getAccountStartDate() {
        return accountStartDate;
    }

    public Date getAccountEndDate() {
        return accountEndDate;
    }

    public double getBalance() {
        return balance;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
}
