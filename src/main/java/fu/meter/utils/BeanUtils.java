package fu.meter.utils;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName BeanUtils
 * @desc 获取Spring中Bean工具类
 * @date 2020/12/24 10:42
 */
@Component
public class BeanUtils extends org.springframework.beans.BeanUtils implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;
    public void setApplicationContext(ApplicationContext applicationContext) {
        BeanUtils.applicationContext=applicationContext;

    }
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void destroy() throws Exception {
        applicationContext = null;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }


}