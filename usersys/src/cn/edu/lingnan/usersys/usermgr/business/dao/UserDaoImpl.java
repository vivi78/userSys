package cn.edu.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.edu.lingnan.usersys.common.exception.DaoException;
import cn.edu.lingnan.usersys.common.util.DBUtils;
import cn.edu.lingnan.usersys.usermgr.domain.UserVO;



/**
 * 用户dao接口的实现类
 * @author lenovo
 *
 */
public class UserDaoImpl implements UserDao{
	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}
	
	/**
	 * 用户登录
	 * @param user 用户信息
	 * @return 用户信息 
	 */
	public UserVO login(String name,String password){
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement ps = null;
		//声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			ps = conn.prepareStatement("select * from t_user where uname=? and passwd=? and status='0'");
			//调用预编译对象的setXxx方法，给？赋值
			ps.setString(1,name);
			ps.setString(2,password);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = ps.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			if(rs.next()){
				//创建一个新用户对象，赋值给用户对象变量
				user = new UserVO();
				/**
				 * 调用结果集对象的getXxx方法，取出各个字段的值，
				 * 然后再调用用户对象的setXxx方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				user.setUno(rs.getString("uno"));
				user.setUname(rs.getString("uname"));
				user.setPasswd(rs.getString("passwd"));
				user.setSuperuser(rs.getString("superuser"));
				user.setSex(rs.getString("sex"));
				user.setBirth(rs.getDate("birth"));
				user.setMail(rs.getString("mail"));
				user.setStatus(rs.getInt("status"));
			}
		//如果出现异常，输出异常信息
		} catch (SQLException e) {
			System.out.println("在插入用户时出错，错误信息为："+e.getMessage());
			//将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错",e);
//			e.printStackTrace();
		}finally{
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, ps);
		}
		/**
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
		 * 如果查询结果为空，该对象为空值null
		 */
		return user;
	}

	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	@Override
	public boolean addUser(UserVO user) {
		//声明一个标志符，用于判断是否注册成功
		boolean flag = false;	
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into t_user values"
					+"('"+user.getUno()+"','"+user.getUname()+"','"+user.getPasswd()+"','"+user.getSuperuser()+"','"+user.getSex()+"','"+user.getBirth()+"','"+user.getMail()+"','"+user.getStatus()+"')");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public int findMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public UserVO findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserVO> findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
