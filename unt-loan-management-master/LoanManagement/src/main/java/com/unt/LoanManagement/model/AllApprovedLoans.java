package com.unt.LoanManagement.model;

import com.unt.LoanManagement.entity.LoanEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AllApprovedLoans {

    int totalApprovedLoansSize;
    List<LoanEntity> approvedLoans;
}
