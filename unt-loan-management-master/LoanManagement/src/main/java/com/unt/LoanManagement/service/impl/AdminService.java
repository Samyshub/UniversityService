package com.unt.LoanManagement.service.impl;

import com.unt.LoanManagement.entity.FinancialOfficerEntity;
import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.model.*;
import com.unt.LoanManagement.repository.*;
import com.unt.LoanManagement.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService {

    @Autowired
    FinancialOfficerRepository financialOfficerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DesignationRepository designationRepository;

    @Override
    public UserEntity saveOfficerDetails(UserModel officerModel) {
        UserEntity financialOfficer = new UserEntity();
        financialOfficer.setUserName(officerModel.getUserName());
        financialOfficer.setFirstName(officerModel.getFirstName());
        financialOfficer.setLastName(officerModel.getLastName());
        financialOfficer.setPassword(officerModel.getPassword());
        financialOfficer.setPhoneNumber(officerModel.getPhoneNumber());
        financialOfficer.setEmailId(officerModel.getEmailId());
        financialOfficer.setDesignationId(officerModel.getDesignationId());
        financialOfficer.setRoleId(officerModel.getRoleId());

        return userRepository.save(financialOfficer);
    }

    @Override
    public AdminDashboardModelResp getAllLoans() {
        AllRejectedLoansModel allRejectedLoansModel = new AllRejectedLoansModel();
        AllApprovedLoans allApprovedLoans = new AllApprovedLoans();
        AllLoansModel allLoansModel = new AllLoansModel();
        AllPendingLoansModel allPendingLoansModel = new AllPendingLoansModel();
        AdminDashboardModelResp adminDashboardModelResp = new AdminDashboardModelResp();
        AllReviewLoans allReviewLoans = new AllReviewLoans();
        List<LoanEntity> allLoans  = loanRepository.findAll();
        List<LoanEntity>  rejectedLoans =  loanRepository.getAllRejectedLoan();
        List<LoanEntity> approvedLoans  = loanRepository.getAllApprovedLoans();
        List<LoanEntity> pendingLoans = loanRepository.getAllPendingLoans();
        List<LoanEntity> reviewLoans = loanRepository.getAllReviewLoans();

        allReviewLoans.setReviewLoans(reviewLoans);
        allReviewLoans.setTotalReviewLoansSize(reviewLoans.size());

        allPendingLoansModel.setPendingLoans(pendingLoans);
        allPendingLoansModel.setTotalPendingLoansSize(pendingLoans.size());
        allLoansModel.setTotalLoansSize(allLoans.size());
        allLoansModel.setAllLoans(allLoans);

        allRejectedLoansModel.setRejectedLoans(rejectedLoans);
        allRejectedLoansModel.setTotalRejectedLoansSize(rejectedLoans.size());

        allApprovedLoans.setApprovedLoans(approvedLoans);
        allApprovedLoans.setTotalApprovedLoansSize(approvedLoans.size());

        adminDashboardModelResp.setAllLoansModel(allLoansModel);
        adminDashboardModelResp.setAllRejectedLoans(allRejectedLoansModel);
        adminDashboardModelResp.setAllApprovedLoans(allApprovedLoans);
        adminDashboardModelResp.setAllReviewLoans(allReviewLoans);

        return adminDashboardModelResp;
    }

    public boolean checkDoesOfficerExists(String officerUserName){
        boolean flag = true;
        FinancialOfficerEntity financialOfficer = financialOfficerRepository.findAllByOfficerUserId(officerUserName);
        if (financialOfficer != null){
            flag = true;
        }else{
            flag = false;
        }
    return flag;
    }


    @Override
    public List<LoginResponseModel> getAllOfficers(){
        List<UserEntity> userEntity = userRepository.findAllByRoleId(3);
        List<LoginResponseModel> list = null;
        if(!Objects.isNull(userEntity)){
        list= userEntity.stream().map(o->{
                LoginResponseModel officerModel = new LoginResponseModel();
                officerModel.setUserName(o.getUserName());
                officerModel.setFirstName(o.getFirstName());
                officerModel.setLastName(o.getLastName());
                officerModel.setEmailId(o.getEmailId());
                officerModel.setPhoneNumber(o.getPhoneNumber());
                officerModel.setRoleId(roleRepository.findAllByRoleId(o.getRoleId()));
                officerModel.setDesignationId(designationRepository.findAllById(o.getDesignationId()));

            return officerModel;
        }).collect(Collectors.toList());
            return list;
        }
    return  list;
    }

    @Override
    public void deleteOfficer(String userId) {
        UserEntity user = userRepository.findAllByUserName(userId);
        userRepository.deleteById(user.getUserId());
    }


}
