package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xuxiao
 */
public class GenTools {

    //自动分配用户号码
    public static String genNo(Connection c, String role) {
	String userNo = null;
	String sql = "SELECT " + role.charAt(0) + "No" + " FROM " + role;  //默认的是ASC升序排列
	System.out.println(sql);/////////////////////////////////

	try {
	    PreparedStatement pstmt = c.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
	    if (!rs.next()) {
		userNo = "00000";
	    } else {
		rs.last(); //取最大的，即最后一个
		int tempNo = Integer.valueOf(rs.getString(1)) + 1;
		if (tempNo / 10 == 0) {
		    userNo = "0000" + tempNo;
		} else if (tempNo / 100 == 0) {
		    userNo = "000" + tempNo;
		} else if (tempNo / 1000 == 0) {
		    userNo = "00" + tempNo;
		} else if (tempNo / 10000 == 0) {
		    userNo = "0" + tempNo;
		}
	    }

	    if (rs != null) {
		rs.close();
	    }
	    if (pstmt != null) {
		pstmt.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return userNo;
    }
///*	把这个功能放在数据库里面自动实现，减少代码
// *
//	//检查是否存在相同的用户名
//	public boolean userExist(Connection conn, String name, String role){
//		//String sql = "SELECT * FROM " + role + " WHERE username = ?";  //默认的是ASC升序排列
//		String sql = "SELECT * FROM " + role + " WHERE " + name + " = ?";
//		System.out.println(sql);
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			//pstmt.setString(1, username);
//			pstmt.setString(1, name);
//			ResultSet rs = pstmt.executeQuery();
//
//			if(rs.next()){
//				return true;
//			}else{
//				return false;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//*/
}
