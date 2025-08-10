package com.publicis.boot.starter.aliyun.sms.config;

import com.aliyun.dysmsapi20180501.Client;
import com.publicis.boot.starter.aliyun.sms.exceptions.AliYunSmsClientException;
import com.publicis.boot.starter.aliyun.sms.exceptions.AliYunSmsConfigException;
import com.publicis.boot.starter.aliyun.sms.service.AliYunSmsService;
import com.publicis.boot.starter.aliyun.sms.service.SmsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@ConditionalOnClass(Client.class)
@EnableConfigurationProperties(AliYunSmsProperties.class)
@ConditionalOnProperty(prefix = "aliyun.sms", value = "access-key-id")
public class AliYunSmsAutoConfiguration {

    private final AliYunSmsProperties properties;

    public AliYunSmsAutoConfiguration(AliYunSmsProperties properties) {
        this.properties = properties;
    }
    @Bean
    @ConditionalOnMissingBean
    public Client  smsClient() {
        com.aliyun.credentials.Client credential = new com.aliyun.credentials.Client();
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setCredential(credential)
                .setAccessKeyId(Optional.ofNullable(properties.getAccessKeyId()).orElseThrow(() -> new AliYunSmsConfigException("accessKeyId")))
                .setAccessKeySecret(Optional.ofNullable(properties.getAccessKeySecret()).orElseThrow(() -> new AliYunSmsConfigException("accessKeySecret")))
                .setEndpoint(properties.getEndpoint())
                .setRegionId(properties.getRegionId())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout());
        try {
            return new Client(config);
        } catch (Exception e) {
            throw new AliYunSmsClientException(e);
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public SmsService smsService(Client client, AliYunSmsProperties properties) {
        return new AliYunSmsService(client, properties);
    }
}
