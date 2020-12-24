package fu.meter.ibatis.common;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.RequestScope;
import fu.meter.ibatis.common.base.BaseDao;
import fu.meter.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
/**
 * @desc Ibatis操作数据库工具类：便于获取SqlMapClient，获取sql语句等。
 * @author meter
 * @date 2020/12/24 9:43
 */
@Slf4j
public class IbatisSqlMapHelper {
	private static final boolean isDebug=true;
	private static BaseDao baseDao;
	static {
		baseDao=BeanUtils.getBean(BaseDao.class);
	}
	/**
	 * @return com.ibatis.sqlmap.client.SqlMapClient
	 * @desc 获取操作数据库的Ibatis-SqlMapClient客户端
	 * @author meter
	 * @date 2020/12/24 9:42
	 */
	public static  SqlMapClient getSqlMap() {
		return baseDao.getSqlMapClient();
	}



	/**
	 * @param sqlId
	 * @param params
	 * @return java.lang.String
	 * @desc 获取待执行的sql语句
	 * @author meter
	 * @date 2020/12/24 9:41
	 */
	public static String getSql(String sqlId, Object params) {
		SqlMapExecutorDelegate delegate = ((ExtendedSqlMapClient) (baseDao.getSqlMapClient())).getDelegate();
		MappedStatement mappedStatement = delegate.getMappedStatement(sqlId);
		RequestScope requestScope = new RequestScope();
		requestScope.setStatement(mappedStatement);
		requestScope.setParameterMap(mappedStatement.getParameterMap());
		Sql sql = mappedStatement.getSql();
		String sqlStr = sql.getSql(requestScope, params);
		if(log.isDebugEnabled() || isDebug) {
			Object[] sqlParam = sql.getParameterMap(requestScope, params).getParameterObjectValues(requestScope, params);
			for (int i = 0; i < sqlParam.length; i++) {
				log.info("第[{}]个参数为:{}", (i + 1), sqlParam[i]);
			}
		}
		return sqlStr;
	}



	public static BaseDao getBaseDao() {
		return baseDao;
	}

	/**
	 * @param sqlId
	 * @param param
	 * @return void
	 * @desc 记录sql
	 * @author meter
	 * @date 2020/12/24 9:51
	 */
	public static void logSql(String sqlId,Object param) {
		if(log.isDebugEnabled() || isDebug){
			String sql = getSql(sqlId, param);
			log.info("获取到id为[{}]对应sql:",sqlId,sql);
		}
	}
	public static void logSql(String sqlId) {
		if(log.isDebugEnabled() || isDebug){
			String sql = getSql(sqlId, null);
			log.info("获取到id为[{}]对应sql:",sqlId,sql);
		}
	}
	/**
	 * @param msg
	 * @param param
	 * @return void
	 * @desc 记录日志
	 * @author meter
	 * @date 2020/12/24 9:22
	 */
	public static void log(String msg,Object... param){
		if(log.isDebugEnabled() || isDebug){
			if(param.length>0){
				log.info(msg,param);
			}else{
				log.info(msg);
			}
		}
	}
}
