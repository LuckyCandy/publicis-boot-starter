package com.publicis.boot.starter.aliyun.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliYunSmsProperties {
    /**
     * 阿里云访问密钥ID
     */
    private String accessKeyId;

    /**
     * 阿里云访问密钥Secret
     */
    private String accessKeySecret;

    /**
     * 短信签名名称
     */
    private String signName;

    /**
     * 短信服务地域ID
     */
    private String regionId = "cn-hangzhou";

    /**
     * 短信服务端点
     */
    private String endpoint = "dysmsapi.aliyuncs.com";

    /**
     * 连接超时时间(秒)
     */
    private int connectTimeout = 10000;

    /**
     * 读取超时时间(秒)
     */
    private int readTimeout = 10000;

    /**
     * 自动重试
     */
    private Boolean autoRetry = false;

    /**
     * 最大重试次数
     */
    private int maxRetry = 3;
}
