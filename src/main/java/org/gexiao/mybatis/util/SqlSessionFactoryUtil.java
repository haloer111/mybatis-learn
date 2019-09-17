package org.gexiao.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactory工具类
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory factory = null;
    private static final String RESOURCES = "mybatis-config.xml";

    private SqlSessionFactoryUtil() {

    }

    private static final Class LOCK = SqlSessionFactoryUtil.class;

    public static SqlSessionFactory getInstance() {
        InputStream inputStream = null;
        if (factory == null) {
            synchronized (LOCK) {
                if (factory == null) {
                    try {
                        inputStream = Resources.getResourceAsStream(RESOURCES);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    factory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }
        return factory;
    }

    public static SqlSession getSqlSession(){
        if (factory == null) {
            getInstance();
        }
        return factory.openSession();
    }
}
