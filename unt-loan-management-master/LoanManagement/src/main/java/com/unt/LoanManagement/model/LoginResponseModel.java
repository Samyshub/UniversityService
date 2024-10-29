package com.unt.LoanManagement.model;

import com.unt.LoanManagement.entity.DesignationEntity;
import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.entity.Role;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseModel {

    public String userName;

    public String emailId;


    public Role roleId;

    public DesignationEntity designationId;

    public String firstName;

    public String lastName;

    public Long phoneNumber;

    public List<LoanEntity> loans;

    public double emi;


}
