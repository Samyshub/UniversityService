package com.unt.LoanManagement.controller;

import com.unt.LoanManagement.config.ApplicationConstants;
import com.unt.LoanManagement.config.CommonResponse;
import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.model.CommonResponseModel;
import com.unt.LoanManagement.model.LoginResponseModel;
import com.unt.LoanManagement.model.UserModel;
import com.unt.LoanManagement.model.WithdrawSendToOfficer;
import com.unt.LoanManagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/unt/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    IUserService iUserService;


    @PostMapping("/save")
    public ResponseEntity<CommonResponseModel<Object>> createUser(@RequestBody UserModel userModel) {
            if (!iUserService.checkDoesUserExits(userModel.getUserName())) {
               UserEntity user = iUserService.saveUserDetails(userModel);
                if (user != null) {
                    return new CommonResponse<>().prepareSuccessResponseMessage(ApplicationConstants.USER_CREATED);
                }else{
                    return  new CommonResponse<>().prepareFailedResponseObject(ApplicationConstants.USER_NOT_CREATED,userModel);
                }
            }
        return  new CommonResponse<>().prepareFailedResponseObject(ApplicationConstants.USER_EXITS_ALREADY,userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponseModel<Object>> login(@RequestBody UserModel userModel){
        if(userModel.getUserName() !=null && userModel.getPassword() != null ){
            LoginResponseModel loginResponseModel = new LoginResponseModel();
            boolean result = iUserService.logIn(userModel,loginResponseModel);
            if (result){
                return new CommonResponse<>().prepareSuccessResponseObjectMessage(ApplicationConstants.LOGIN_SUCCESS,loginResponseModel);
            }else{
                return new CommonResponse<>().prepareFailedResponseObject(ApplicationConstants.USER_PASSWORD_MISMATCH,userModel);
            }
        }
        return new CommonResponse<>().prepareFailedResponseObject(ApplicationConstants.USER_PASSWORD_MISSING,userModel);
    }


    @GetMapping("/sendToOfficer/{loanId}")
    public ResponseEntity<CommonResponseModel<Object>> sendToOfficer(@PathVariable  Integer loanId){
        LoanEntity loanEntity = iUserService.sendToOfficer(loanId);
        if(loanEntity != null){
            return new CommonResponse<>().prepareSuccessResponseObjectMessage("Loan Request  has sent to OFFICER",loanEntity);
        }else{
            return new CommonResponse<>().prepareFailedResponseObject("unable to send loan request to officer",loanId);
        }
    }


    @PostMapping("/withdraw/sendToOfficer")
    public ResponseEntity<CommonResponseModel<Object>> withdrawSendToOfficer(@RequestBody WithdrawSendToOfficer drawSendToOfficer){
        LoanEntity loanEntity = iUserService.withdrawSendToOfficer(drawSendToOfficer);
        if(loanEntity != null){
            return new CommonResponse<>().prepareSuccessResponseObjectMessage("Loan Request  has sent to OFFICER",loanEntity);
        }else{
            return new CommonResponse<>().prepareFailedResponseObject("unable to send loan request to officer",drawSendToOfficer);
        }
    }



}
