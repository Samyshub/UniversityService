package com.unt.LoanManagement.service;

import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.model.LoginResponseModel;
import com.unt.LoanManagement.model.UserModel;
import com.unt.LoanManagement.model.WithdrawSendToOfficer;

public interface IUserService {

     UserEntity saveUserDetails(UserModel userModel);
     boolean checkDoesUserExits(String username);

     boolean logIn(UserModel userModel, LoginResponseModel loginResponseModel);

     LoanEntity sendToOfficer(Integer loanID);

     LoanEntity withdrawSendToOfficer(WithdrawSendToOfficer drawSendToOfficer);

}
