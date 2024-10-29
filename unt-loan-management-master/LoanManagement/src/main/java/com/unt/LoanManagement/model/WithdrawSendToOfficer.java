package com.unt.LoanManagement.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WithdrawSendToOfficer {

    private Integer loanId;

    private Double withdrawLoanAmount;

    private  Integer routingNumber;

    private Integer accountNumber;

}
