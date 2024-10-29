package com.unt.LoanManagement.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminDashboardModelResp {

    private   AllLoansModel allLoansModel;

    private  AllApprovedLoans allApprovedLoans;

    private  AllRejectedLoansModel allRejectedLoans;

    private AllReviewLoans allReviewLoans;

}
