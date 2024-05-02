package cn.edu.zuel.utils;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;
    static {
        try{
            InputStream resourceAsStream =JdbcUtil.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties=new Properties();
            properties.load(resourceAsStream);
            driverClass=properties.getProperty("driverClass");
            url=properties.getProperty("url");
            user= properties.getProperty("user");
            password=properties.getProperty("password");
            Class.forName(driverClass);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){//建立连接
        try{
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection){//关闭查询连接
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void closeConnection(Statement statement, Connection connection){//关闭修改数据连接
        closeConnection(null,statement,connection);
    }
    public static void beginTransaction(Connection connection){//开始事务
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void endTransaction(Connection connection){//结束事务
        try{
            connection.setAutoCommit(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void rollbackTransaction(Connection connection){//回滚事务
        try{
            if(connection!=null){
                connection.rollback();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static  void commit(Connection connection){//提交事务
        try{
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
