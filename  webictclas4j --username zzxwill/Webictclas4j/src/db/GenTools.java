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

    //�Զ������û�����
    public static String genNo(Connection c, String role) {
	String userNo = null;
	String sql = "SELECT " + role.charAt(0) + "No" + " FROM " + role;  //Ĭ�ϵ���ASC��������
	System.out.println(sql);/////////////////////////////////

	try {
	    PreparedStatement pstmt = c.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
	    if (!rs.next()) {
		userNo = "00000";
	    } else {
		rs.last(); //ȡ���ģ������һ��
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
///*	��������ܷ������ݿ������Զ�ʵ�֣����ٴ���
// *
//	//����Ƿ������ͬ���û���
//	public boolean userExist(Connection conn, String name, String role){
//		//String sql = "SELECT * FROM " + role + " WHERE username = ?";  //Ĭ�ϵ���ASC��������
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
