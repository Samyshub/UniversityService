package com.unt.LoanManagement.service;

import com.unt.LoanManagement.entity.FinancialOfficerEntity;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.model.AdminDashboardModelResp;
import com.unt.LoanManagement.model.FinancialOfficerModel;
import com.unt.LoanManagement.model.LoginResponseModel;
import com.unt.LoanManagement.model.UserModel;

import java.util.List;

public interface IAdminService {

     UserEntity saveOfficerDetails(UserModel officerModel);

     AdminDashboardModelResp getAllLoans();

     List<LoginResponseModel> getAllOfficers();

     void deleteOfficer(String userId);

}
