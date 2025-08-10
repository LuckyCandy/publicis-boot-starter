package com.publicis.boot.starter.aliyun.sms.service;

import java.util.function.Consumer;

public interface SmsService {
    /**
     * Universal text message sending
     * @param phoneNumber String
     * @param templateCode String
     * @param templateParam String
     */
    void sendWithTemplate(String phoneNumber, String templateCode, String templateParam) throws Exception;

    /**
     * Send text messages and customize the handling of exceptions
     */
    void sendWithTemplate(String phoneNumber, String templateCode, String templateParam, Consumer<Throwable> onError);
}
