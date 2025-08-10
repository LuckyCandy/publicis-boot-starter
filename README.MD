# 基于Spring Boot V3 封装一些常用的starter

目前已有的starter如下：

|Starter|Desc|
|---|---|
|aliyun-sms-publicis-boot-starter|封装阿里云短信服务，2018 java（非异步）版本|

## 1 aliyun-sms-publicis-boot-starter

### 1.1 导入依赖

```xml
<dependency>
    <groupId>com.publicis.boot.starter</groupId>
    <artifactId>aliyun-sms-spring-boot-starter</artifactId>
    <version>${target.version}</version>
</dependency>
```

### 1.2 在配置文件增加`sms`相关配置
```yaml
aliyun:
    sms:
        access-key-id: fake-access-key-id
        access-key-secret: fake-access-key-secret
        sign-name: damon 
```

此处的三个是必须参数，其他配置，可在集成时查看，有对应提示信息的

### 1.3 使用

目前仅提供发送模板短信的两个变种，一个忽略错误，一个提供自定义时的错误处理。
    
```java
void sendWithTemplate(String phoneNumber, String templateCode, String templateParam) throws Exception;
void sendWithTemplate(String phoneNumber, String templateCode, String templateParam, Consumer<Throwable> onError);
```

