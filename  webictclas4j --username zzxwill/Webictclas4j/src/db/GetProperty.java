package db;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author xuxiao
 */
public class GetProperty {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    static String sql = "";

    //for provider and seller, accessory
    public static String getUserByNumber(String role, String numberName, String userNo) {
	conn = DbConnection.getConnection();
	sql = "SELECT * FROM " + role + " WHERE " + numberName + " = ?";
	try {
	    pstmt = conn.prepareStatement(sql);
	    //pstmt.setString(1, numberName);
	    pstmt.setString(1, userNo);

	    rs = pstmt.executeQuery();
	    if (rs.next()) {
		//return rs.getString("Name");
		return rs.getString(role.charAt(0) + "Name");
	    } else {
		return null;
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    try {
		conn.close();
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	    return "sql error";
	}
    }

    //for all user
    public static String getUsernameByNumber(String role, String numberName, String userNo) {
	conn = DbConnection.getConnection();
	sql = "SELECT * FROM " + role + " WHERE " + numberName + " = ?";
	try {
	    pstmt = conn.prepareStatement(sql);
	    //pstmt.setString(1, numberName);
	    pstmt.setString(1, userNo);

	    rs = pstmt.executeQuery();
	    if (rs.next()) {
		return rs.getString("username");
	    } else {
		return null;
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    try {
		conn.close();
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	    return "sql error";
	}
    }

    //just for seller and provider
    public static ArrayList<String> getNumberByUsername(String role, String storeName, String uname) {
	ArrayList<String> numList = new ArrayList<String>();

	conn = DbConnection.getConnection();
	sql = "SELECT * FROM " + role + " WHERE " + storeName + " = ?";
	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, "%" + uname + "%");

	    rs = pstmt.executeQuery();
	    while (rs.next()) {
		numList.add(rs.getString(role.charAt(0) + "No"));
	    }

	    return numList;
	    /*
	    if(rs.next()){
	    return rs.getString(role.charAt(0) + "No");
	    }else{
	    return null;
	    }
	     */
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    try {
		conn.close();
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	    //return "sql error";
	    return null;
	}
    }

    public static BigDecimal getAccountByUserNumber(String role, String userNo) {
	String sql;
	String numName = role.charAt(0) + "No";
	String accountName = role.charAt(0) + "Account";
	String priceName;

	conn = DbConnection.getConnection();
	sql = "SELECT * FROM " + role + " WHERE (" + numName + " = ?)";
	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, userNo);
	    rs = pstmt.executeQuery();
	    //
	    if (rs.next()) {
		return rs.getBigDecimal(accountName);
	    } else {
		return null;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    try {
		conn.close();
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	    return null;
	}
    }

    public static BigDecimal getPriceByUserNumber(String num, String type) {
	String sql = "";
	String priceName;
	String numName;

	if (type.equalsIgnoreCase("computer")) {
	    priceName = "compPrice";
	    numName = "compNo";
	} else {
	    priceName = "aPrice";
	    numName = "aNo";
	}
	sql = "SELECT * FROM " + type + " WHERE (" + numName + " = ?)";
	conn = db.DbConnection.getConnection();
	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, num);
	    rs = pstmt.executeQuery();

	    if (rs.next()) {
		return rs.getBigDecimal(priceName);
	    } else {
		return null;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    try {
		conn.close();
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	    return null;
	}
    }

//	//´ýÍêÉÆ¡£¡£¡£
//	/*
//	public static int getQuantityByUserNumber(String num, String type){
//		String sql = "";
//		String quantityName;
//		String numName;
//
//		if(type.equalsIgnoreCase("orders")){
//			quantityName = "oQuantity";
//			numName = "oNo";
//		}else{
//			quantityName = type + "Quantity";
//			if()
//		}
//		sql = "SELECT * FROM " + type + " WHERE (" + numName + " = ?)";
//		conn = db.DbConnection.getConnection();
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//			rs = pstmt.executeQuery();
//
//			return rs.getInt(priceName);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				conn.close();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			return -1;
//		}
//	}
//	*/
    public static void main(String[] args) {
	//System.out.println(db.GetProperty.getUserByNumber("seller", "sNo", "00001"));
	//System.out.println(db.GetProperty.getUserByNumber("accessory", "aNo", "00001"));
	//System.out.println(db.GetProperty.getUsernameByNumber("manager", "mNo", "00001"));

	System.out.println(db.GetProperty.getAccountByUserNumber("consumer", "00000"));

	//System.out.println(db.GetProperty.getNumberByUsername("seller", "sName", "a"));

	//TestBigDecimal compare
	BigDecimal d1 = BigDecimal.valueOf(1);
	BigDecimal d2 = BigDecimal.valueOf(2);
	System.out.println(d1.compareTo(d2));
    }
}
