package com.unt.LoanManagement.repository;

import com.unt.LoanManagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


//    @Query(value = "SELECT * FROM USER_TABLE where USER_NAME = 'username'",nativeQuery = true)
//    UserEntity findByUserName(@Param("username") String userName);


    UserEntity findAllByUserName(@Param("username") String userName);

    List<UserEntity> findAllByRoleId(@Param("roleID") Integer roleId);

}
