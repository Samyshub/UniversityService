package com.unt.LoanManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "FINANCIAL_OFFICER")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FinancialOfficerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OFFICER_ID")
    private  Integer officerId;

    @Column(name = "OFFICER_USER_ID")
    private String officerUserId;

    @Column(name = "OFFICER_FIRST_NAME")
    private String officerFirstName;

    @Column(name = "OFFICER_LAST_NAME")
    private String  officerLastName;



    @Column(name = "OFFICER_PASSWORD")
    private String officerPassword;

    @Column(name = "OFFICER_EMAIL_ID")
    private String officerEmailId;

    @Column(name = "OFFICER_CONTACT_NUMBER")
    private Long officerContactNumber;

    @Column(name = "OFFICER_Joining_Date")
    private Date officerJoiningDate;

    @Column(name ="IS_ACTIVE")
    private String isActive;




}
