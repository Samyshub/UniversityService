package com.unt.LoanManagement.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseModel {

    private String bankName;

    private String loanType;

    private  double rateOfInterest;

    private double loanAmount;

    private  String userName;

    private  Integer years;

    private String loanStatus;

    private double EMI;

    private String coSignerName;

    private double coSignerIncome;

    private String coSignerRelation;

    private Integer coSignerPhoneNumber;

}
