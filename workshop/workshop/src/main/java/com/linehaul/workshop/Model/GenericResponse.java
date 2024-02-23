package com.linehaul.workshop.Model;

public class GenericResponse {
    public Integer respCode;
    public String respMessage;
    public Object respData;

    public GenericResponse() {
    }

    public GenericResponse(Integer respCode, String respMessage, Object respData) {
        this.respCode = respCode;
        this.respMessage = respMessage;
        this.respData = respData;
    }
}
