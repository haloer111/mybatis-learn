package org.gexiao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.gexiao.mybatis.dao.UserMapper;
import org.gexiao.mybatis.entity.User;
import org.gexiao.mybatis.enums.Sex;
import org.gexiao.mybatis.util.SqlSessionFactoryUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther: gexiao
 * @Date: 2019/9/17 09:50
 * @Description:
 */
public class DBConnectionTest {

    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    /**
     * 使用xml方式创建SqlSessionFactory
     *
     * @throws IOException
     */
//    @Before
//    public void prepareXML() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        factory = new SqlSessionFactoryBuilder().build(inputStream);
//        inputStream.close();
//    }

    /**
     * 使用java代码的方式创建SqlSessionFactory，一般不使用这种方式
     *
     * @throws IOException
     */
//    @Before
//    public void prepareJava() throws IOException {
//        //构建数据源
//        PooledDataSource dataSource = new PooledDataSource() {{
//            setDriver("com.mysql.jdbc.Driver");
//            setUrl("jdbc:mysql://120.77.252.112:3306/mybatis");
//            setUsername("root");
//            setPassword("gexiao");
//        }};
//        //构建事务factory
//        TransactionFactory txFactory = new JdbcTransactionFactory();
//        //创建数据库运行环境
//        Environment environment = new Environment("development", txFactory, dataSource);
//        //构建configuration对象
//        Configuration configuration = new Configuration(environment);
//        configuration.setLazyLoadingEnabled(true);
////        configuration.setEnhancementEnabled(true);
//        //添加映射器
//        configuration.addMapper(UserMapper.class);
//        //添加别名
//        configuration.getTypeAliasRegistry().registerAlias("user", User.class);
//        factory = new SqlSessionFactoryBuilder().build(configuration);
//    }
    @Before
    public void prepareBySqlSessionFactoryUtil() {
        sqlSession = SqlSessionFactoryUtil.getInstance().openSession();
    }

    /**
     * 查询user根据id
     */
    @Test
    public void getById() {
        //方式一
//        SqlSession sqlSession = factory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getById1(1L);
//        System.out.println("user = " + user);
        //方式二

        //”mapper全限名+方法名“
        User selectOne = (User) sqlSession.selectOne("org.gexiao.mybatis.dao.UserMapper.getById", 1L);
        //如果方法名没有重复的可以简写 “方法名” 的方式
//        User selectOne = (User)sqlSession.selectOne("getById1", 1L);
        System.out.println("user = " + selectOne);
    }

    /**
     * 查询user根据id
     */
    @Test
    public void getById2() {
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getById2(1L);
        System.out.println("user = " + user);
    }

    @Test
    public void getById3() {
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getById3("user", 1L);
        System.out.println("user = " + user);
    }

    /**
     * 插入一条数据
     */
    @Test
    public void insert() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User() {{
            setAge(15);
            setSex(Sex.FEMALE);
            setName("小王八");
        }};
        Long result = mapper.insert(user);
        sqlSession.commit();
    }

    /**
     * 插入一条数据，返回id
     */
    @Test
    public void insert1() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User() {{
            setAge(15);
            setSex(Sex.FEMALE);
            setName("小王八");
        }};
        //这只是返回是否插入成功的结果，如果设置了插入回调主键，应该从user对象中去获取id
        Long result = mapper.insert1(user);
        sqlSession.commit();
        Assert.assertNotNull(user.getId());
    }

    /**
     * 插入一条数据，返回id
     */
    @Test
    public void insert2() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User() {{
            setAge(15);
            setSex(Sex.FEMALE);
            setName("小王八");
        }};
        //这只是返回是否插入成功的结果，如果设置了插入回调主键，应该从user对象中去获取id
        Long result = mapper.insert2(user);
        sqlSession.commit();
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void deleteById() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteById(9L);
        sqlSession.commit();
        Assert.assertTrue(result == 1);

    }
}
