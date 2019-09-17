package org.gexiao.mybatis.type;

import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 17:11
 * @Description:
 */
//@MappedTypes({String.class})
//@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyStringTypeHandler implements TypeHandler<String> {
    private Logger logger = Logger.getLogger(MyStringTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("使用我的typeHandler");
        ps.setString(i, parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        logger.info("使用我的typeHandler,ResultSet 列名获取字符串");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        logger.info("使用我的typeHandler,ResultSet 下标获取字符串");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        logger.info("使用我的typeHandler,CallableStatement 下标获取字符串");
        return cs.getString(columnIndex);
    }
}
