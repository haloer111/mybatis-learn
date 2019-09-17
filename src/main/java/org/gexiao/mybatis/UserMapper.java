package org.gexiao.mybatis;

import org.apache.ibatis.annotations.Param;
import org.gexiao.entity.User;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 09:58
 * @Description:
 */
public interface UserMapper {

    User getById(@Param("id") Long id);
}
