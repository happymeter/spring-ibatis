package fu.meter.app.test;

import fu.meter.ibatis.common.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @desc 测试Ibatis
 * @date 2020/12/24 11:36
 */
@Service
public class DemoService implements BaseService {
    private final String PREFIX="fu.meter.app.test.Demo.";
    @Transactional
    public void saveDemo(Demo demo){
        insert(PREFIX+"insertDemo",demo);
    }
    public void updateDemo(Demo demo){
        update(PREFIX+"updateDemo",demo);
    }
    public Demo selectDemo(Demo demo){
       return (Demo) queryObject(PREFIX+"selectDemo",demo);
    }
    public List<Demo> selectDemos(Demo demo){
        return  queryList(PREFIX+"selectDemo",demo);
    }
    public void deleteDemo(Demo demo){
        delete(PREFIX+"deleteDemo",demo);
    }

}
