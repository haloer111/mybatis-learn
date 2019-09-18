package org.gexiao.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.gexiao.mybatis.entity.User;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 09:58
 * @Description:
 */
public interface UserMapper {

    User getById(@Param("id") Long id);

    User getById2(@Param("id") Long id);

    @Select("select id,name,age,sex from user where id = #{id}")
    User getById1(@Param("id") Long id);

    Long insert( User user);
    Long insert1( User user);
    Long insert2( User user);

    int deleteById(@Param("id") Long id);
}
