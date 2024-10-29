package com.unt.LoanManagement.repository;

import com.unt.LoanManagement.entity.FinancialOfficerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialOfficerRepository extends JpaRepository<FinancialOfficerEntity,Integer> {

    FinancialOfficerEntity findAllByOfficerUserId(@Param("officerUserId") String officerUserId);
}
