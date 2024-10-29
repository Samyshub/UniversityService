package com.unt.LoanManagement.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestModel {

    private String bankName;

    private String loanType;

    private  String rateOfInterest;

    private double loanAmount;

    private  String userName;

    private  Integer years;

    private String coSignerName;

    private double coSignerIncome;

    private String coSignerRelation;

    private Integer coSignerPhoneNumber;

}
