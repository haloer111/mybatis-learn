package org.gexiao.mybatis.type;

import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.gexiao.mybatis.enums.Sex;

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
public class SexEnumTypeHandler implements TypeHandler<Sex> {
    private Logger logger = Logger.getLogger(SexEnumTypeHandler.class);


    @Override
    public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getId());
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
         return Sex.get(rs.getInt(columnName));
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Sex.get(rs.getInt(columnIndex));
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Sex.get(cs.getInt(columnIndex));
    }
}
