package com.unt.LoanManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "LOAN_ENTITY")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LoanEntity {

    @Id
    @Column(name = "LOAN_ID",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer loadId;
    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "LOAN_TYPE")
    private String loanType;

    @Column(name = "RATE_OF_INTEREST")
    private  Double rateOfInterest;
    @Column(name = "LOAN_AMOUNT")
    private Double loanAmount;

    @Column(name = "LOAN_STATUS")
    private  String loanStatus;


    @Column(name = "USER_NAME")
    private  String userName;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "YEARS")
    private Integer years;

    @Column(name = "EMI")
    private double EMI;


    @Column(name = "CO_SIGNER_NAME")
    private String coSignerName;

    @Column(name = "CO_SIGNER_INCOME")
    private double coSignerIncome;

    @Column(name = "CO_SIGNER_RELATION")
    private String coSignerRelation;

    @Column(name = "CO_SIGNER_PHONE_NUMBER")
    private Integer coSignerPhoneNumber;


    @Column(name = "WITHDRAW_LOAN_AMOUNT")
    private Double withdrawLoanAmount;

    @Column(name = "WITHDRAW_ROUTING_NUMBER")
    private  Integer routingNumber;

    @Column(name = "WITHDRAW_ACCOUNT_NUMBER")
    private Integer accountNumber;




}
