package com.ohgiraffers.section01.mybatis.Common;

import com.mysql.cj.jdbc.Driver;
import com.ohgiraffers.section01.mybatis.Model.dao.MenuMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MenuTemplate {

    private static SqlSessionFactory sqlSessionFactory;
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USERNAME = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static SqlSession getSqlSession(){

        if(sqlSessionFactory == null) {

            Environment environment = new Environment("dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD));

            Configuration con = new Configuration(environment);

            con.addMapper(MenuMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(con);
        }

        return sqlSessionFactory.openSession(false);
    }
}
