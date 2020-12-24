# Spring boot and Ibatis

老项目使用Ibatis2.3，整合spring boot 2.3.4；方便不修改旧系统原有sql逻辑的情况下使用spring boot相关功能；

> 项目使用spring-framework-3.0.0.M1中的spring-orm中的ibatis源码，整合到当前项目中。为了不和新的spring冲突，修改了包路径名。

## 使用方法

1、可以继承BaseDao或者BaseService。

2、可以使用模板工具类：``SqlMapClientTemplate``，或者直接使用ibatis包中的类：``SqlMapClient``

然后编写sql对应的mapper文件，把mapper对应的xml文件配置到config/sql_map_config.xml文件中：例如：

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE sqlMapConfig
PUBLIC "-//iBATIS.com//DTD SQL Map Config 2.0//EN"
"http://www.ibatis.com/dtd/sql-map-config-2.dtd">
<sqlMapConfig>

	<settings cacheModelsEnabled="true" enhancementEnabled="true"
		lazyLoadingEnabled="true" errorTracingEnabled="true" maxRequests="32"
		maxSessions="10" maxTransactions="5" useStatementNamespaces="true" />
	<!-- 每个映射文件得手动配置进来 -->
	<sqlMap resource="mappings/demo.xml"/>
</sqlMapConfig>
```

继承BaseService：

```java
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

```



