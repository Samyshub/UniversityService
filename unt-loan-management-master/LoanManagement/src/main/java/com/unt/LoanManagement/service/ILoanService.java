package com.unt.LoanManagement.service;

import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.model.ApproveRejectModel;
import com.unt.LoanManagement.model.LoanRequestModel;
import com.unt.LoanManagement.model.LoanResponseModel;
import com.unt.LoanManagement.model.LoginResponseModel;

public interface ILoanService {

    LoanResponseModel loanRequest(LoanRequestModel loanRequestModel);

    LoginResponseModel getAllLoanRequests(String userName);

    LoanEntity approveRejectLoan(ApproveRejectModel approveRejectModel);
}
