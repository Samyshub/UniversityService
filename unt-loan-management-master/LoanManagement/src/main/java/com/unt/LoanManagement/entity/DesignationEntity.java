package com.unt.LoanManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "DESIGNATION")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DesignationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",unique = true,nullable = false)
    private Integer id;


    @Column(name = "DESIGNATION",unique = true,nullable = false)
    private String designation;
}
