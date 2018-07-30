package cn.edu.lingnan.usersys.common.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.edu.lingnan.usersys.common.exception.DateException;
import cn.edu.lingnan.usersys.common.exception.EmailException;

/**
 * 类型转换
 * @author lenovo
 *
 */
public class TypeUtils {
	/**
	 * 字符串转换为日期
	 * @param str 指定字符串
	 * @return 转换的日期
	 */
	public static Date strToDate(String str){
		Date date = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法将字符串解析成指定格式的日期类型
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new DateException("字符串转换为日期出错！",e);
			//e.printStackTrace();
		}
		//返回转换后的日期
		return date;
	}
	
	/**
	 * 日期转换为字符串
	 * @param date 指定日期
	 * @return 转换的字符串
	 */
	public static String dateToString(Date date){
		String str = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用format方法将日期转换成字符串
			str = sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			throw new DateException("日期转换为字符串出错！",e);
		}
		return str;
	}
	
	/**
	 * 邮箱检测
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		try {
			String mail = email.replaceAll("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$", "");
			if(mail.length()==0){
				return true;
			}else{
				System.out.println("邮箱格式错误！");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmailException("邮箱格式错误！",e);
		}
	}

}



