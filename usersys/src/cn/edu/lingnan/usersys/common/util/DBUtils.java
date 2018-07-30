package cn.edu.lingnan.usersys.common.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.lingnan.usersys.common.exception.DaoException;

/**
 * 数据库工具类
 * @author lenovo
 *
 */

public class DBUtils {
	/**
	 * 获取数据库连接的方法
	 * @return 返回获取到的链接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//加载数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url="jdbc:oracle:thin:@localhost:1521:orcl"; //orcl为数据库的SID
			String user="scott"; 
			String password="orcl"; 
			//获取数据库连接对象
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("无法建立数据库连接！");
			//e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new DaoException("创建数据库连接对象失败！");
			//e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new DaoException("数据库连接失败！");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DaoException("驱动程序加载错误！");
			//e.printStackTrace();
		} 	
		return conn;
	}
	
	/**
	 * 开启事务
	 * @param conn 开启事务的数据库链接
	 */
	public static void beginTransaction(Connection conn){
		try {
			//设置事物的自动提交模式为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("开启事务失败！",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commit(Connection conn){
		try {
			//提交事务
			conn.commit();
			//设置事务的自动提交模式为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("提交事务失败！",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollback(Connection conn){
		try {
			//回滚事务
			conn.rollback();
			//设置事务的自动提交模式为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("回滚事务失败！",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try {
			//如果数据库连接对象不为空，关闭该对象
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("关闭连接对象失败！",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭statement
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs,Statement stmt){
		try {
			//如果查询结果集对象不为空，关闭该对象
			if(rs!=null){
				rs.close();
			}
			//如果声明对象不为空，关闭该对象
			if(stmt!=null){
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("关闭声明对象失败！",e);
			//e.printStackTrace();
		}
	}
	
}
