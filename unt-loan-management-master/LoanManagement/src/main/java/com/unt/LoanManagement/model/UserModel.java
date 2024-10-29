package com.unt.LoanManagement.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserModel {

    public String userName;

    public String emailId;

    public String password;

    public Integer roleId;

    public Integer designationId;

    public String firstName;

    public String lastName;

    public Long phoneNumber;
}
