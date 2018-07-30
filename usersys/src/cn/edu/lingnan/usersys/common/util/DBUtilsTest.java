package cn.edu.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;


public class DBUtilsTest {

	@Test
	public void testGetConnection() {
		Connection conn = DBUtils.getConnection();
		System.out.println(conn);
	}

}
