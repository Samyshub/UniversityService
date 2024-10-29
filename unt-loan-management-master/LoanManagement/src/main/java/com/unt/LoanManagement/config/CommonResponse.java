package com.unt.LoanManagement.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.unt.LoanManagement.model.CommonResponseModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CommonResponse<R> {



    public ResponseEntity<CommonResponseModel<R>> prepareFailedResponse(String errorMsg){
        CommonResponseModel<R> commonResponseModel = new CommonResponseModel<>();
        commonResponseModel.setStatusCode(ApplicationConstants.FAILED_STATUS);
        commonResponseModel.setStatus(ApplicationConstants.FAILED);
        commonResponseModel.setError(errorMsg);
        return  new ResponseEntity<>(commonResponseModel, HttpStatus.OK);
    }

    public ResponseEntity<CommonResponseModel<R>> prepareFailedResponseObject(String errorMsg,R resultData){
        CommonResponseModel<R> commonResponseModel = new CommonResponseModel<>();
        commonResponseModel.setResult(getResultData(resultData));
        commonResponseModel.setStatusCode(ApplicationConstants.FAILED_STATUS);
        commonResponseModel.setStatus(ApplicationConstants.FAILED);
        commonResponseModel.setError(errorMsg);
        return  new ResponseEntity<>(commonResponseModel, HttpStatus.OK);

    }


    public ResponseEntity<CommonResponseModel<R>> prepareSuccessResponseObject(R resultData){
        CommonResponseModel<R> commonResponseModel = new CommonResponseModel<>();
        commonResponseModel.setResult(getResultData(resultData));
        commonResponseModel.setStatusCode(ApplicationConstants.SUCCESS_STATUS);
        commonResponseModel.setStatus(ApplicationConstants.SUCCESS);
        return  new ResponseEntity<>(commonResponseModel, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<CommonResponseModel<R>> prepareSuccessResponseMessage(String message){
        CommonResponseModel<R> commonResponseModel = new CommonResponseModel<>();
        commonResponseModel.setStatusCode(ApplicationConstants.SUCCESS_STATUS);
        commonResponseModel.setStatus(message);
        return  new ResponseEntity<>(commonResponseModel, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<CommonResponseModel<R>> prepareSuccessResponseObjectMessage(String status,R resultData){
        CommonResponseModel<R> commonResponseModel = new CommonResponseModel<>();
        commonResponseModel.setResult(getResultData(resultData));
        commonResponseModel.setStatusCode(ApplicationConstants.SUCCESS_STATUS);
        commonResponseModel.setStatus(status);
        return  new ResponseEntity<>(commonResponseModel, HttpStatus.OK);
    }

    public ResponseEntity<CommonResponseModel<R>> prepareInternalServerError(String error,R resultData){
        CommonResponseModel<R> commonResponseModel = new CommonResponseModel<>();
        commonResponseModel.setResult(getResultData(resultData));
        commonResponseModel.setStatusCode(ApplicationConstants.INTERNAL_SERVER_STATUS);
        commonResponseModel.setStatus(ApplicationConstants.INTERNAL_SERVER_ERROR);
        commonResponseModel.setError(error);
        return  new ResponseEntity<>(commonResponseModel, HttpStatus.OK);
    }

    
    
    private List<R> getResultData(R resultData){
        List<R>  result = new ArrayList<>();
        if (resultData instanceof JSONObject){
            result.add(resultData);
            
        } else if (resultData instanceof List) {
            result = (List) resultData;
            
        } else if (resultData instanceof JSONArray) {
            result = (List) resultData;
        } else {
            result.add(resultData);
        }
        return  result;
    } 
}
