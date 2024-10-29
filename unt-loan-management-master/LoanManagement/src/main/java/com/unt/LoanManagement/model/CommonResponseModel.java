package com.unt.LoanManagement.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommonResponseModel<T> {

    private  String status;

    private  Integer statusCode;

    private List<T> result;

    private String error;
}
