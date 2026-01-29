package com.wipro.bank.main;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.service.BankService;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        BankService bankService = new BankService();

        System.out.println("Before Transfer:");
        System.out.println(bankService.checkBalance("1234567890"));

        TransferBean transferBean = new TransferBean();
        transferBean.setFromAccountNumber("1234567890");
        transferBean.setToAccountNUmber("1234567891");
        transferBean.setAmount(25500);

        // ✅ FIX: use java.sql.Date
        transferBean.setDateOfTransaction(
                new Date(System.currentTimeMillis())
        );

        System.out.println(bankService.transfer(transferBean));

        System.out.println("After Transfer:");
        System.out.println(bankService.checkBalance("1234567890"));
    }
}
