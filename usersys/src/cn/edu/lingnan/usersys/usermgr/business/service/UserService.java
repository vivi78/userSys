package cn.edu.lingnan.usersys.usermgr.business.service;

import cn.edu.lingnan.usersys.usermgr.domain.UserVO;

public interface UserService {
	
	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user);
	
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 用户密码
	 * @return 用户信息
	 */
	public UserVO login(String name,String password);

}
