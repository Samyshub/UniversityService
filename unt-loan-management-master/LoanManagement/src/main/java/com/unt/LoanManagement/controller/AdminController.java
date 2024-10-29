package com.unt.LoanManagement.controller;

import com.unt.LoanManagement.config.ApplicationConstants;
import com.unt.LoanManagement.config.CommonResponse;
import com.unt.LoanManagement.entity.FinancialOfficerEntity;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.model.*;
import com.unt.LoanManagement.service.IUserService;
import com.unt.LoanManagement.service.impl.AdminService;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("unt/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    IUserService userService;



    @PostMapping("/save/officer")
    public ResponseEntity<CommonResponseModel<Object>> saveOfficer(@RequestBody UserModel officerModel){
        boolean isOfficerExist = userService.checkDoesUserExits(officerModel.getUserName());
        if(!isOfficerExist){
            UserEntity financialOfficer =  adminService.saveOfficerDetails(officerModel);
            if(financialOfficer != null){
                return  new CommonResponse<>().prepareSuccessResponseObjectMessage("Officer Created Successfully",financialOfficer);
            }else{
                return  new CommonResponse<>().prepareFailedResponse("unable to create Officer. Please try again later");
            }
        }
        return new CommonResponse<>().prepareFailedResponseObject("Officer Already Exists",officerModel);
    }

    @GetMapping("/dashboard/getLoans")
    public ResponseEntity<CommonResponseModel<Object>> getAllLoans(){
        AdminDashboardModelResp adminDashboardModelResp = adminService.getAllLoans();
        if (adminDashboardModelResp != null){
            return  new CommonResponse<>().prepareSuccessResponseObjectMessage("Loans Fetched Successfully",adminDashboardModelResp);
        }else{
            return  new CommonResponse<>().prepareFailedResponse("unable to Fetch Loans Successfully. Please try again later");
        }
    }

    @GetMapping("/getOfficers")
    public ResponseEntity<CommonResponseModel<Object>> getAllOfficers(){
        List<LoginResponseModel> list = adminService.getAllOfficers();
        if(list != null){
            return  new CommonResponse<>().prepareSuccessResponseObjectMessage("Officers Fetched Successfully",list);
        }else{
            return  new CommonResponse<>().prepareFailedResponse("unable to Fetch Officers Successfully. Please try again later");
        }

    }


    @GetMapping("/delete/officer/{userId}")
    public ResponseEntity<CommonResponseModel<Object>> deleteOfficer(@PathVariable String userId){
        if(userId != null){
            adminService.deleteOfficer(userId);
            return  new CommonResponse<>().prepareSuccessResponseMessage("Officers Deleted Successfully");
        }else{
            return  new CommonResponse<>().prepareFailedResponse("unable to delete Officer. Please try again later");
        }
    }

}
