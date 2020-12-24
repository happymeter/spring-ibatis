package fu.meter.app.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName IbatisDemo
 * @desc 测试Ibatis
 * @date 2020/12/24 11:32
 */
@Component
@Slf4j
public class IbatisDemo {
    @Autowired
    private DemoService demoService;
    @Scheduled(cron = "0/5 * * * * ?")
    public void runYesterday() {
     // testSave();
        testQuery();
    }
    /**
     * @return void
     * @desc 测试查询
     * @author meter
     * @date 2020/12/24 12:09
     */
    private void testQuery() {
        Demo demo=new Demo();
        demo.setName("meter");
        List<Demo> demos = demoService.selectDemos(demo);
        demos.forEach(d->{
            log.info(d.toString());
        });
    }
    /**
     * @return void
     * @desc 测试保存
     * @author meter
     * @date 2020/12/24 12:09
     */
    private void testSave() {
        for(int i=0;i<20;i++){
            Demo demo=new Demo();
            demo.setName("meter-"+i);
            demo.setAge(22+i);
            //demo.setFlag("0");
            demoService.saveDemo(demo);
        }
    }
}
