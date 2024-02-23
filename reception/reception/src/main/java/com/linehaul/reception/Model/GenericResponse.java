package com.linehaul.reception.Model;

public class GenericResponse {
        public Integer respCode;
        public String respMessage;
        public Object respData;

        public GenericResponse(Integer respCode, String respMessage, Object respData) {
            this.respCode = respCode;
            this.respMessage = respMessage;
            this.respData = respData;
        }
}
