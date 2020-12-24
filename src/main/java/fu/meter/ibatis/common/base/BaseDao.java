package fu.meter.ibatis.common.base;

import com.ibatis.sqlmap.client.SqlMapClient;
import fu.meter.ibatis.support.SqlMapClientTemplate;
import fu.meter.ibatis.common.IbatisSqlMapHelper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName BaseDao
 * @desc 公共dao
 * @date 2020/12/23 17:28
 */
@Repository
@Data
public class BaseDao {
    @Autowired
    protected SqlMapClientTemplate sqlMapClientTemplate;

    public SqlMapClient getSqlMapClient() {
        return sqlMapClientTemplate.getSqlMapClient();
    }

    public SqlMapClientTemplate getSqlMapClientTemplate() {
        return sqlMapClientTemplate;
    }
    public List queryForList(String sqlId){
        IbatisSqlMapHelper.logSql(sqlId);
        return sqlMapClientTemplate.queryForList(sqlId);
    }
    public List queryForList(String sqlId, Object param){
        IbatisSqlMapHelper.logSql(sqlId,param);
        return sqlMapClientTemplate.queryForList(sqlId,param);
    }

    protected Object queryObject(String sqlId, Object paramMap) {
        IbatisSqlMapHelper.logSql(sqlId,paramMap);
        return sqlMapClientTemplate.queryForObject(sqlId, paramMap);
    }

    protected Integer queryInteger(String sqlId, Object paramMap) {
        IbatisSqlMapHelper.logSql(sqlId,paramMap);
        return (Integer) sqlMapClientTemplate.queryForObject(sqlId, paramMap);
    }

    protected void insert(String sqlId,Object param){
        sqlMapClientTemplate.insert(sqlId,param);
    }
    protected void update(String sqlId,Object param){
        sqlMapClientTemplate.update(sqlId,param);
    }
    protected void delete(String sqlId,Object param){
        sqlMapClientTemplate.delete(sqlId,param);
    }
}
