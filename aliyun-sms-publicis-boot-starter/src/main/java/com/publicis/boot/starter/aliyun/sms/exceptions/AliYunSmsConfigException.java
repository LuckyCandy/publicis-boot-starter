package com.publicis.boot.starter.aliyun.sms.exceptions;

public class AliYunSmsConfigException extends AliYunSmsException{
    public AliYunSmsConfigException(String propertyName) {
        super("The configuration attribute of Alibaba SMS is missing: " + propertyName);
    }
}
