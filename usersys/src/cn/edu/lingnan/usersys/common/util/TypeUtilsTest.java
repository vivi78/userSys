package cn.edu.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TypeUtilsTest {

	@Test
	public void testStrToDate() {
		Date date = TypeUtils.strToDate("2000-1-1");
		System.out.println("---1---"+date);
	}

	@Test
	public void testDateToString() {
		Date date = new Date();
		String string = TypeUtils.dateToString(date);
		System.out.println("---2---"+string);
	}

	@Test
	public void testCheckEmail() {
		boolean flag = false;
		flag = TypeUtils.checkEmail("11111@qq.com");
		if(flag)
			System.out.println("邮箱格式正确");
		else {
			System.out.println("邮箱格式错误");
		}
	}

}
