package org.jh.usercenter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author MangoGovo
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "user-center")
public class Properties {
    private String grpc;
}