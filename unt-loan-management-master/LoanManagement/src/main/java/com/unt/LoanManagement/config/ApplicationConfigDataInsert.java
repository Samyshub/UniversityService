package com.unt.LoanManagement.config;

import com.unt.LoanManagement.entity.DesignationEntity;
import com.unt.LoanManagement.entity.FinancialOfficerEntity;
import com.unt.LoanManagement.entity.Role;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.repository.DesignationRepository;
import com.unt.LoanManagement.repository.FinancialOfficerRepository;
import com.unt.LoanManagement.repository.RoleRepository;
import com.unt.LoanManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConfigDataInsert {

    @Autowired
    DesignationRepository designationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;




    @Bean
    CommandLineRunner saveRoles (){
        return args -> {
            List<Role> roleList = new ArrayList<>();
            Role admin = new Role(1, ApplicationConstants.ADMIN);
            Role user = new Role(2,ApplicationConstants.USER);
            Role financialOfficer = new Role(3,ApplicationConstants.OFFICER);
            roleList.add(admin);
            roleList.add(user);
            roleList.add(financialOfficer);
            roleRepository.saveAll(roleList);
        };
    }

    @Bean
    CommandLineRunner saveAdmin(){
        return  args -> {
            List<UserEntity> admin = new ArrayList<>();
            UserEntity userEntity = new UserEntity(1,"admin","admin first","admin last","admin@gmail.com",1234L,"admin",1,3);
            admin.add(userEntity);
            userRepository.saveAll(admin);
        };
    }

    @Bean
    CommandLineRunner saveDesignation (){
        return args -> {
            List<DesignationEntity> list = new ArrayList<>();
            DesignationEntity student = new DesignationEntity(1,ApplicationConstants.STUDENT);
            DesignationEntity faculty = new DesignationEntity(2,ApplicationConstants.FACULTY);
            DesignationEntity financialOfficer = new DesignationEntity(3,ApplicationConstants.OFFICER);
            list.add(student);
            list.add(faculty);
            list.add(financialOfficer);
            designationRepository.saveAll(list);

        };
    }


}
