package org.jh.usercenter;

import jakarta.annotation.Resource;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MangoGovo
 */
@Configuration
public class BeanRegister {
    @Resource
    private Properties properties;

    @Bean
    public UserCenterService userCenterService() {
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        ReferenceConfig<UserCenterService> ref = new ReferenceConfig<>();
        ref.setInterface(UserCenterService.class);
        ref.setProtocol(CommonConstants.TRIPLE);
        ref.setProxy(CommonConstants.NATIVE_STUB);
        ref.setTimeout(10000);
        ref.setUrl(properties.getGrpc());
        bootstrap.reference(ref);
        return ref.get();
    }
}
