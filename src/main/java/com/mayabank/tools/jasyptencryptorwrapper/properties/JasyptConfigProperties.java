package com.mayabank.tools.jasyptencryptorwrapper.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "jasypt")
@Configuration
public class JasyptConfigProperties {
    private String password;
    private String rawString;
    private String algorithm;
    private Integer keyObtentionIterations;
    private Integer poolSize;
    private String saltGeneratorClassName;
    private String ivGeneratorClassName;
    private String stringOutputType;
}
