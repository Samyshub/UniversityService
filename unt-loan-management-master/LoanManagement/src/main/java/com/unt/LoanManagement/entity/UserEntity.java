package com.unt.LoanManagement.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "USER_TABLE")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;


    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL_ID",unique = true, nullable = false)
    private String emailId;

    @Column(name = "PHONE_NUMBER",unique = true, nullable = false)
    private Long phoneNumber;



    @Column(name = "PASSWORD", nullable = false)
    private String password;


    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;

    @Column(name = "DESIGNATION_ID", nullable = false)
    private Integer designationId;

}
