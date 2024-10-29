package com.unt.LoanManagement.controller;

import com.unt.LoanManagement.config.CommonResponse;
import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.model.*;
import com.unt.LoanManagement.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/unt/loan")
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    ILoanService iLoanService;
    @PostMapping("/applyLoan")
    public ResponseEntity<CommonResponseModel<Object>> requestLoan(@RequestBody LoanRequestModel loanRequestModel){

        if( loanRequestModel != null ){
            LoanResponseModel  loanResponseModel =  iLoanService.loanRequest(loanRequestModel);
            if(!Objects.isNull(loanResponseModel)){
                return new CommonResponse<>().prepareSuccessResponseObjectMessage("Loan has applied successfully",loanResponseModel);
            }
            return new CommonResponse<>().prepareFailedResponseObject("Loan has not applied successfully",loanRequestModel);
        }
        return new CommonResponse<>().prepareFailedResponse("Unable to proceed now please try again later");
    }

    @PostMapping("/getLoans")
    public ResponseEntity<CommonResponseModel<Object>> getAllLoans(@RequestBody LoanRequestModel loanRequestModel){
        if(loanRequestModel.getUserName() != null){
            LoginResponseModel loginResponseModel = iLoanService.getAllLoanRequests(loanRequestModel.getUserName());
            if(!Objects.isNull(loginResponseModel)){
                return new CommonResponse<>().prepareSuccessResponseObjectMessage("Loan details fetched successfully",loginResponseModel);
            }
            return new CommonResponse<>().prepareFailedResponseObject("Loan details not fetched successfully",loanRequestModel);
        }
        return new CommonResponse<>().prepareFailedResponse("Unable to fetch loan details now please try again later");
    }




    @PostMapping("/approveOrReject")
    public ResponseEntity<CommonResponseModel<Object>> approveOrReject(@RequestBody ApproveRejectModel approveRejectModel){
        LoanEntity loanEntity = iLoanService.approveRejectLoan(approveRejectModel);
        if(loanEntity != null){
            return new CommonResponse<>().prepareSuccessResponseObjectMessage("Loan Request has updated ",loanEntity);
        }else{
            return new CommonResponse<>().prepareFailedResponseObject("unable to update loan request from officer",approveRejectModel);
        }
    }


    @PostMapping("withdraw/approveOrReject")
    public ResponseEntity<CommonResponseModel<Object>> withdrawApproveOrReject(@RequestBody ApproveRejectModel approveRejectModel){
        LoanEntity loanEntity = iLoanService.approveRejectLoan(approveRejectModel);
        if(loanEntity != null){
            return new CommonResponse<>().prepareSuccessResponseObjectMessage("Loan Request has updated ",loanEntity);
        }else{
            return new CommonResponse<>().prepareFailedResponseObject("unable to update loan request from officer",approveRejectModel);
        }
    }




}
