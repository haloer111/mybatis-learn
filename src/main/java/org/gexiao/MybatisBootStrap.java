package org.gexiao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.gexiao.mybatis.dao.UserMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 14:21
 * @Description:
 */
public class MybatisBootStrap {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getById(1L));
        } finally {
            session.close();
        }
    }
}
