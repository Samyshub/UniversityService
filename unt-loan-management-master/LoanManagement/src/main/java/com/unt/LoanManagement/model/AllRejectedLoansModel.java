package com.unt.LoanManagement.model;

import com.unt.LoanManagement.entity.LoanEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AllRejectedLoansModel {

    int totalRejectedLoansSize;
    List<LoanEntity> rejectedLoans;
}
