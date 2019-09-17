package org.gexiao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 09:50
 * @Description:
 */
public class DBConnectionTest {

    private SqlSessionFactory factory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMybatis() {
        SqlSession sqlSession = factory.openSession();
        Assert.assertNotNull(sqlSession);
    }
}
