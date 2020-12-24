package fu.meter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName CmccApplication
 * @desc 移动程序启动类
 * @date 2020/12/23 9:45
 */
@SpringBootApplication
@ComponentScan({"fu.meter.utils","fu.meter.ibatis","fu.meter.app"})
@EnableScheduling
public class IbatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(IbatisApplication.class,args);
    }
}
