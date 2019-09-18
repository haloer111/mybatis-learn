package org.gexiao.mybatis.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.gexiao.mybatis.enums.Sex;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 09:59
 * @Description:
 */
@Data
@Alias("user")
public class User {
    private Long id;
    private String name;
    private int age;
    private Sex sex;
}
