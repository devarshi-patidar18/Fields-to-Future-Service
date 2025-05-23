package com.apis.Fields_To_Future_Services.DTOs;


public class ResponseDto<M> {

    private String responseName;

    private M data;

    public ResponseDto(M data, String responseName) {
        this.data = data;
        this.responseName = responseName;
    }

    public ResponseDto() {
    }

    public void setData(M data) {
        this.data = data;
    }
    public M getData() {
        return data;
    }

    public String getResponseName() {
        return responseName;
    }
    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }
}
