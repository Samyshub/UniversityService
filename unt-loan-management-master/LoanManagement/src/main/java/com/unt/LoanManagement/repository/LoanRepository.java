package com.unt.LoanManagement.repository;

import com.unt.LoanManagement.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Integer> {

    @Query(value = "SELECT * FROM LOAN_ENTITY WHERE USER_NAME=:userName AND LOAN_STATUS in ('PENDING','APPROVED','REJECTED','CREDITED','DECLINED')",nativeQuery = true)
    List<LoanEntity>  getAllLoanRequests(@Param("userName") String userName);

    @Query(value = "SELECT * FROM LOAN_ENTITY WHERE LOAN_STATUS='REJECTED'",nativeQuery = true)
    List<LoanEntity>  getAllRejectedLoan();


    @Query(value = "SELECT * FROM LOAN_ENTITY WHERE  LOAN_STATUS='APPROVED'",nativeQuery = true)
    List<LoanEntity>  getAllApprovedLoans();

    @Query(value = "SELECT * FROM LOAN_ENTITY WHERE  LOAN_STATUS='PENDING'",nativeQuery = true)
    List<LoanEntity>  getAllPendingLoans();

    @Query(value = "SELECT * FROM LOAN_ENTITY WHERE  LOAN_STATUS in ('REVIEW','WITHDRAW-REVIEW')",nativeQuery = true)
    List<LoanEntity>  getAllReviewLoans();

    @Query(value = "SELECT * FROM  LOAN_ENTITY WHERE LOAN_ID=:loanId",nativeQuery = true)
    LoanEntity sendToOfficer(@Param("loanId") Integer loanId);
}
