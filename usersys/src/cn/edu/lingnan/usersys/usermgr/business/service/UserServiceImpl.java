package cn.edu.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;

import cn.edu.lingnan.usersys.common.constant.EnumType;
import cn.edu.lingnan.usersys.common.dao.DaoFactory;
import cn.edu.lingnan.usersys.common.exception.DaoException;
import cn.edu.lingnan.usersys.common.exception.ServiceException;
import cn.edu.lingnan.usersys.common.util.DBUtils;
import cn.edu.lingnan.usersys.usermgr.business.dao.UserDao;
import cn.edu.lingnan.usersys.usermgr.domain.UserVO;

public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例，在类的内部创建唯一的实例
	 */
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 构造方法私有化
	 */
	private UserServiceImpl(){
		
	}
	
	/**
	 * 取得用户service实例
	 * 提供对外访问的方法
	 * @return 实例对象
	 */
	public static UserService getInstance(){
		return userService;
	}
	
	public UserVO login(String name,String password){
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		UserVO user = null;
		
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
			user = userMgrDao.login(name, password);
		}catch(DaoException e){
			//将自定义异常并抛出
			throw e;
		}catch(Exception e){
			//将异常封装或自定义异常并抛出
			throw new ServiceException("用户登录错误",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
    	//返回用户登录结果
    	return user;
     }

	@Override
	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
		return false;
	}
}
