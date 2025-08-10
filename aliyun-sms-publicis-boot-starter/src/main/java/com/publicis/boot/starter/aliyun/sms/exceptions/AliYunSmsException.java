package com.publicis.boot.starter.aliyun.sms.exceptions;

public class AliYunSmsException extends RuntimeException{

    public AliYunSmsException(String message) {
        super(message);
    }
    public AliYunSmsException(String message, Throwable cause) {
        super(message, cause);
    }
}
