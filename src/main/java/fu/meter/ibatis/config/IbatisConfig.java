package fu.meter.ibatis.config;


import com.ibatis.sqlmap.client.SqlMapClient;
import fu.meter.ibatis.support.SqlMapClientFactoryBean;
import fu.meter.ibatis.support.SqlMapClientTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName IbatisConfig
 * @desc ibatis初始化配置
 * @date 2020/12/23 14:10
 */
@Configuration
public class IbatisConfig {
    private static String resource = "config/sql_map_config.xml";
    @Bean
    public SqlMapClientFactoryBean sqlMapClient(DataSource dataSource){
        SqlMapClientFactoryBean sqlMapClientFactoryBean = new SqlMapClientFactoryBean();
        sqlMapClientFactoryBean.setDataSource(dataSource);
        sqlMapClientFactoryBean.setConfigLocation(new ClassPathResource(resource));
        return sqlMapClientFactoryBean;
    }
    @Bean
    public SqlMapClientTemplate sqlMapClientTemplate(SqlMapClient sqlMapClient){
        SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
        return sqlMapClientTemplate;
    }

}
