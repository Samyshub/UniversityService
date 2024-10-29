package com.unt.LoanManagement.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FinancialOfficerModel {

    private Integer officerId;

    private String officerFirstName;

    private String officerLastName;

    private String officerUserId;

    private String officerMailId;

    private String officerPassword;

    private Long officerPhoneNumber;

    private Integer officerRoleId;

    private Integer officerDesignationId;

    private String officerJoiningDate;

}
