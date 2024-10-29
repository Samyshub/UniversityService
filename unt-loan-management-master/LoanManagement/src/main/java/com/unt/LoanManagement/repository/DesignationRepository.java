package com.unt.LoanManagement.repository;

import com.unt.LoanManagement.entity.DesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity,Integer> {

    DesignationEntity findAllById(@Param("id") Integer id);
}
