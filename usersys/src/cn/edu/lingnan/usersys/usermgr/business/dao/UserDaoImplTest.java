package cn.edu.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.smartcardio.CommandAPDU;

import org.junit.Test;

import cn.edu.lingnan.usersys.common.util.DBUtils;
import cn.edu.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testLogin() {
		Connection conn = DBUtils.getConnection();
		UserDaoImpl userDaoImpl = new UserDaoImpl(conn);
		UserVO user = new UserVO();
		user = userDaoImpl.login("aaa", "aaa");
		System.out.println(user.getUno()+"   "+user.getUname()+"   "+user.getPasswd());
	}

}
