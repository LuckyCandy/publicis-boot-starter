package com.publicis.boot.starter.aliyun.sms.service;

import java.util.function.Consumer;

public interface SmsService {
    /**
     * Send template message
     * @param phoneNumber String
     * @param templateCode String
     * @param templateParam String
     */
    void sendWithTemplate(String phoneNumber, String templateCode, String templateParam) throws Exception;

    /**
     * Send template messages and customize the handling of exceptions
     * @param phoneNumber String
     * @param templateCode String
     * @param templateParam String
     * @param onError Consumer<Throwable>
     */
    void sendWithTemplate(String phoneNumber, String templateCode, String templateParam, Consumer<Throwable> onError);
}
