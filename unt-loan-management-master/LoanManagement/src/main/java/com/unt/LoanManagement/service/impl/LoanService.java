package com.unt.LoanManagement.service.impl;

import com.unt.LoanManagement.entity.DesignationEntity;
import com.unt.LoanManagement.entity.LoanEntity;
import com.unt.LoanManagement.entity.UserEntity;
import com.unt.LoanManagement.model.ApproveRejectModel;
import com.unt.LoanManagement.model.LoanRequestModel;
import com.unt.LoanManagement.model.LoanResponseModel;
import com.unt.LoanManagement.model.LoginResponseModel;
import com.unt.LoanManagement.repository.DesignationRepository;
import com.unt.LoanManagement.repository.LoanRepository;
import com.unt.LoanManagement.repository.RoleRepository;
import com.unt.LoanManagement.repository.UserRepository;
import com.unt.LoanManagement.service.ILoanService;
import com.unt.LoanManagement.service.loan.AbstractFactory;
import com.unt.LoanManagement.service.loan.Bank;
import com.unt.LoanManagement.service.loan.FactoryCreator;
import com.unt.LoanManagement.service.loan.Loan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements ILoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DesignationRepository designationRepository;

    @Override
    public LoanResponseModel loanRequest(LoanRequestModel loanRequestModel) {

        List<LoanEntity> list = new ArrayList<>();
        prepareLoanEntity(loanRequestModel, list);
        double emi = prepareCaluclation(loanRequestModel);
        list.get(0).setEMI(emi);
        LoanResponseModel loanResponseModel = prepareLoanResponse(loanRequestModel, emi);
        loanRepository.saveAll(list);
    return loanResponseModel;
    }

    @Override
    public LoginResponseModel getAllLoanRequests(String userName) {
        UserEntity userEntity = userRepository.findAllByUserName(userName);
        List<LoanEntity> loanEntity= loanRepository.getAllLoanRequests(userName);

        LoginResponseModel loginResponseModel = new LoginResponseModel();
        if(userEntity != null){
            loginResponseModel.setEmailId(userEntity.getEmailId());
            loginResponseModel.setFirstName(userEntity.getFirstName());
            loginResponseModel.setLastName(userEntity.getLastName());
            loginResponseModel.setPhoneNumber(userEntity.getPhoneNumber());
            loginResponseModel.setUserName(userEntity.getUserName());
            loginResponseModel.setRoleId(roleRepository.findAllByRoleId(userEntity.getRoleId()));
            loginResponseModel.setDesignationId(designationRepository.findAllById(userEntity.getDesignationId()));
            loginResponseModel.setLoans(loanEntity);


            return loginResponseModel;
        }
    return null;
    }

    @Override
    public LoanEntity approveRejectLoan(ApproveRejectModel approveRejectModel) {
        LoanEntity loanEntity = null;
        if(approveRejectModel != null){
            loanEntity =  loanRepository.sendToOfficer(approveRejectModel.getLoanId());
            if(loanEntity  != null){
                loanEntity.setLoanStatus(approveRejectModel.getStatus());
                loanRepository.save(loanEntity);
                return loanEntity;
            }
        }
        return  null;

    }

    private static LoanResponseModel prepareLoanResponse(LoanRequestModel loanRequestModel, double emi) {
        LoanResponseModel loanResponseModel = new LoanResponseModel();
        loanResponseModel.setBankName(loanRequestModel.getBankName());
        loanResponseModel.setLoanType(loanRequestModel.getLoanType());
        loanResponseModel.setLoanAmount(loanRequestModel.getLoanAmount());
        loanResponseModel.setRateOfInterest(Double.parseDouble(loanRequestModel.getRateOfInterest()));
        loanResponseModel.setLoanStatus("PENDING");
        loanResponseModel.setUserName(loanRequestModel.getUserName());
        loanResponseModel.setEMI(emi);
        loanResponseModel.setYears(loanRequestModel.getYears());
        loanResponseModel.setCoSignerIncome(loanRequestModel.getCoSignerIncome());
        loanResponseModel.setCoSignerName(loanRequestModel.getCoSignerName());
        loanResponseModel.setCoSignerPhoneNumber(loanRequestModel.getCoSignerPhoneNumber());
        loanResponseModel.setCoSignerRelation(loanRequestModel.getCoSignerRelation());

        return loanResponseModel;
    }

    private static double prepareCaluclation(LoanRequestModel loanRequestModel) {
        AbstractFactory bankFactory  = FactoryCreator.getFactory("BANK");
        Bank bank = bankFactory.getBank(loanRequestModel.getBankName());
        AbstractFactory abstractFactory = FactoryCreator.getFactory("Loan");
        Loan l = abstractFactory.getLoan(loanRequestModel.getLoanType());
        double rate =  l.getInterestRate(Double.parseDouble(loanRequestModel.getRateOfInterest()));
        double emi = l.calculateLoanPayment(loanRequestModel.getLoanAmount(), loanRequestModel.getYears());
        return emi;
    }

    private static void prepareLoanEntity(LoanRequestModel loanRequestModel, List<LoanEntity> list) {
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setBankName(loanRequestModel.getBankName());
        loanEntity.setLoanType(loanRequestModel.getLoanType());
        loanEntity.setLoanAmount(loanRequestModel.getLoanAmount());
        loanEntity.setRateOfInterest(Double.parseDouble(loanRequestModel.getRateOfInterest()));
        loanEntity.setLoanStatus("PENDING");
        loanEntity.setUserName(loanRequestModel.getUserName());
        loanEntity.setYears(loanRequestModel.getYears());
        loanEntity.setCoSignerIncome(loanRequestModel.getCoSignerIncome());
        loanEntity.setCoSignerName(loanRequestModel.getCoSignerName());
        loanEntity.setCoSignerRelation(loanRequestModel.getCoSignerRelation());
        loanEntity.setCoSignerPhoneNumber(loanRequestModel.getCoSignerPhoneNumber());
        list.add(loanEntity);
    }
}
