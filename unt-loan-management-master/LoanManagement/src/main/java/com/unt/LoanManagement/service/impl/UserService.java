package com.unt.LoanManagement.service.impl;

import com.unt.LoanManagement.config.ApplicationConstants;
import com.unt.LoanManagement.entity.DesignationEntity;
import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.entity.Role;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.exceptions.GenericException;
import com.unt.LoanManagement.exceptions.NotFoundException;
import com.unt.LoanManagement.model.LoginResponseModel;
import com.unt.LoanManagement.model.UserModel;
import com.unt.LoanManagement.model.WithdrawSendToOfficer;
import com.unt.LoanManagement.repository.DesignationRepository;
import com.unt.LoanManagement.repository.LoanRepository;
import com.unt.LoanManagement.repository.RoleRepository;
import com.unt.LoanManagement.repository.UserRepository;
import com.unt.LoanManagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DesignationRepository designationRepository;

    @Autowired
    LoanRepository loanRepository;

    @Override
    public UserEntity saveUserDetails(UserModel userModel) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userModel.getUserName());
            userEntity.setEmailId(userModel.getEmailId());
            userEntity.setPassword(userModel.getPassword());
            userEntity.setDesignationId(userModel.getDesignationId());
            userEntity.setRoleId(userModel.getRoleId());
            userEntity.setFirstName(userModel.getFirstName());
            userEntity.setLastName(userModel.getLastName());
            userEntity.setPhoneNumber(userModel.getPhoneNumber());
        return userRepository.save(userEntity);
    }

    @Override
    public boolean checkDoesUserExits(String username) {
        boolean flag = true;
        UserEntity user = userRepository.findAllByUserName(username);
        if (user != null){
            flag = true;
        }else{
            flag = false;
        }
        return  flag;
    }

    @Override
    public boolean logIn(UserModel userModel, LoginResponseModel loginResponseModel) {
        boolean flag = false;
        UserEntity userEntity = userRepository.findAllByUserName(userModel.getUserName());

        if(!Objects.isNull(userEntity)){
            if(userModel.getPassword().equals(userEntity.getPassword())){
                Role role = roleRepository.findAllByRoleId(userEntity.getRoleId());
                DesignationEntity designationEntity = designationRepository.findAllById(userEntity.getDesignationId());
                loginResponseModel.setDesignationId(designationEntity);
                loginResponseModel.setRoleId(role);
                loginResponseModel.setUserName(userEntity.getUserName());
                loginResponseModel.setLastName(userEntity.getLastName());
                loginResponseModel.setFirstName(userEntity.getFirstName());
                loginResponseModel.setEmailId(userEntity.getEmailId());
                loginResponseModel.setPhoneNumber(userEntity.getPhoneNumber());
                loginResponseModel.setEmailId(userEntity.getEmailId());
                flag=true;
            }else{
                flag =false;
            }
        }
        return flag;

    }

    @Override
    public LoanEntity sendToOfficer(Integer loanID) {
        LoanEntity loanEntity = loanRepository.sendToOfficer(loanID);
        if (loanEntity != null){
            loanEntity.setLoanStatus("REVIEW");
            loanRepository.save(loanEntity);
            return loanEntity;
        }
        return  null;
    }

    @Override
    public LoanEntity withdrawSendToOfficer(WithdrawSendToOfficer drawSendToOfficer) {
        LoanEntity loanEntity = loanRepository.sendToOfficer(drawSendToOfficer.getLoanId());
        loanEntity.setWithdrawLoanAmount(drawSendToOfficer.getWithdrawLoanAmount());
        loanEntity.setRoutingNumber(drawSendToOfficer.getRoutingNumber());
        loanEntity.setAccountNumber(drawSendToOfficer.getAccountNumber());
        loanEntity.setLoanStatus(ApplicationConstants.WITHDRAW_REVIEW);
        loanRepository.save(loanEntity);
        return  loanEntity;
    }
}
