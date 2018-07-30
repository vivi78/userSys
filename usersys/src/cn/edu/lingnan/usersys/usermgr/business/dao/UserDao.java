package cn.edu.lingnan.usersys.usermgr.business.dao;

import cn.edu.lingnan.usersys.common.dao.BaseDao;
import cn.edu.lingnan.usersys.usermgr.domain.UserVO;

import java.util.List;

/**
 * 用户dao接口
 * @author lenovo
 *
 */
public interface UserDao extends BaseDao{
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
	 * @return
	 */
	public UserVO login(String name,String password);
	
	/**
	 * 查找最大id值
	 * @return 最大id值
	 */
	public int findMaxId();
	
	/**
	 * 根据id查找用户
	 * @param id 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public UserVO findUserById(int id);
	
	/**
	 * 根据用户名查找用户
	 * @param name 用户信息
	 * @return 用户列表
	 */
	public List<UserVO> findUserByName(String name);

}
