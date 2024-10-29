package com.unt.LoanManagement.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApproveRejectModel {

    private Integer loanId;

    private String status;
}
