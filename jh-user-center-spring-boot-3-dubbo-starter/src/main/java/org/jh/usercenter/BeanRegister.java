package org.jh.usercenter;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.jh.usercenter.api.UserCenterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MangoGovo
 */
@Configuration
@Slf4j
public class BeanRegister {
    @Resource
    private Properties properties;

    @Bean
    public UserCenterService userCenterService() {
        try{
            DubboBootstrap bootstrap = DubboBootstrap.getInstance();
            ReferenceConfig<UserCenterService> ref = new ReferenceConfig<>();
            ref.setInterface(UserCenterService.class);
            ref.setProtocol(CommonConstants.TRIPLE);
            ref.setProxy(CommonConstants.NATIVE_STUB);
            ref.setTimeout(10000);
            ref.setUrl(properties.getGrpc());
            bootstrap.reference(ref);
            return ref.get();
        }catch (Exception e){
            log.error("用户中心调用失败,{}",e.getMessage(), e);
            return null;
        }
    }
}
