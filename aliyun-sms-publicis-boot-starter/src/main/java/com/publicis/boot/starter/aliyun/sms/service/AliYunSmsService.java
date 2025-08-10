package com.publicis.boot.starter.aliyun.sms.service;


import com.aliyun.dysmsapi20180501.Client;
import com.aliyun.dysmsapi20180501.models.SendMessageWithTemplateRequest;
import com.aliyun.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import com.publicis.boot.starter.aliyun.sms.config.AliYunSmsProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class AliYunSmsService implements SmsService{
    private final Client client;

    private final AliYunSmsProperties properties;

    public AliYunSmsService(Client client, AliYunSmsProperties properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public void sendWithTemplate(String phoneNumber, String templateCode, String templateParam) throws Exception {
        sendSms(phoneNumber, templateCode, templateParam);
    }

    @Override
    public void sendWithTemplate(String phoneNumber, String templateCode, String templateParam, Consumer<Throwable> onError) {
        try {
            sendSms(phoneNumber, templateCode, templateParam);
        } catch (Exception e) {
            onError.accept(e);
        }
    }


    private  void sendSms(String phoneNumber, String templateCode, String templateParam) throws Exception {
        SendMessageWithTemplateRequest templateRequest = new SendMessageWithTemplateRequest();
        templateRequest.templateCode = templateCode;
        templateRequest.templateParam = templateParam;
        templateRequest.to = phoneNumber;
        templateRequest.from = properties.getSignName();
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.setAutoretry(properties.getAutoRetry()).setMaxAttempts(properties.getMaxRetry());
        SendMessageWithTemplateResponse sendMessageWithTemplateResponse = client.sendMessageWithTemplateWithOptions(templateRequest, runtimeOptions);
    }
}
