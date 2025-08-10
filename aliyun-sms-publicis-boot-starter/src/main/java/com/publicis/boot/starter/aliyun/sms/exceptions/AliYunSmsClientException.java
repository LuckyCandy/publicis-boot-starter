package com.publicis.boot.starter.aliyun.sms.exceptions;

public class AliYunSmsClientException extends AliYunSmsException{
    public AliYunSmsClientException(Throwable cause) {
        super("The Alibaba Cloud SMS client is experiencing an anomaly", cause);
    }
}
