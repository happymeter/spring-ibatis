package fu.meter.ibatis.common.base;

import fu.meter.ibatis.common.IbatisSqlMapHelper;

import java.util.List;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName BaseService
 * @desc Service基类
 * @date 2020/12/24 11:37
 */
public interface BaseService {
     BaseDao baseDao= IbatisSqlMapHelper.getBaseDao();

     default List queryList(String sqlId, Object param){
          return baseDao.queryForList(sqlId,param);
     }
     default List queryList(String sqlId){
          return baseDao.queryForList(sqlId);
     }
     default Object queryObject(String sqlId,Object param){
          return baseDao.queryObject(sqlId,param);
     }
     default Object queryObject(String sqlId){
          return queryObject(sqlId,null);
     }

     default Integer queryInteger(String sqlId){
          return  queryInteger(sqlId,null);
     }
     default Integer queryInteger(String sqlId,Object param){
          return baseDao.queryInteger(sqlId,param);
     }
     default void insert(String sqlId,Object param){
          baseDao.insert(sqlId,param);
     }
     default void update(String sqlId,Object param){
          baseDao.update(sqlId,param);
     }
     default void delete(String sqlId,Object param){
          baseDao.delete(sqlId,param);
     }
}
