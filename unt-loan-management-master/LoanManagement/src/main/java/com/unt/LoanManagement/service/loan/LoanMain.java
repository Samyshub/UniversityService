package com.unt.LoanManagement.service.loan;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

public class LoanMain {







    public static void main(String[] args) {
        String bankName = "HDFC";
        String loanName = "Home";
        double rate = Double.parseDouble("7");
        double loanAmount = Double.parseDouble("100000");
        int years = Integer.parseInt("2");

        AbstractFactory bankFactory = FactoryCreator.getFactory("BANK");

        Bank bank = bankFactory.getBank(bankName);
        AbstractFactory abstractFactory = FactoryCreator.getFactory("Loan");
        Loan l = abstractFactory.getLoan(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount,years);


    }



}
