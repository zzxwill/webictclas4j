/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *这个类用于从本体数据库中获取需要的东西
 * @author xuxiao
 */
public class GetFromOnto {

    /**
     * 从数据库中获取所有Aciton的列表。返回一个ArrayList
     * @return
     */
    public static ArrayList getAllAction() {
	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
//	System.out.println(conn);
	if (conn != null) {
	    /**先把第一级的ACTION从DB中取出来。把ACTION一级一级地从DB中取出来，依次存入ARRAYLIST中完成后返回List**/
	    String sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Action\" ) ) ";
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
//		    System.out.println(rs.getString(1));
		    tmplist.add(rs.getString(1));
		}
//		if (rs.next()) {
//		    System.out.println(rs.getString(1));
//		}
//		return tmplist;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    /**取第二级ACTION**/
	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Action\" ) ) )";//get actionL2
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
//		    System.out.println(rs.getString(1));
		    tmplist.add(rs.getString(1));
		}
//		if (rs.next()) {
//		    System.out.println(rs.getString(1));
//		}
//		return tmplist;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    /**取第三级ACTION**/
	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Action\" ) ) ) )";//get actionL3
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
//		    System.out.println(rs.getString(1));
		    tmplist.add(rs.getString(1));
		}
//		if (rs.next()) {
//		    System.out.println(rs.getString(1));
//		}
		return tmplist;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	} else {
	    System.out.println("Connection open error!");
	}
	return null;
    }

    /**
     * 从数据库中获取所有Event的列表。返回一个ArrayList
     * @return
     */
    public static ArrayList getAllEvent() {
	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	if (conn != null) {
	    /**
	     * 先把第一级的EVENT从DB中取出来。存入ARRAYLIST中完成后返回List
	     *EVENT只有一级*/
	    String sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Event\" ) ) ";
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
		return tmplist;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	} else {
	    System.out.println("Connection open error!");
	}
	return null;
    }

    /**
     * 从数据库中获取所有的Entity列表。返回一个ArrayList
     * @return
     */
    public static ArrayList getAllEntity() {
	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	if (conn != null) {
	    String sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Entity\" ) ) ";//get EntityL1
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Entity\" ) ) )";//get EntityL2
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Entity\" ) ) ) )";//get EntityL3
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
		return tmplist;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} else {
	    System.out.println("Connection open error!");
	}
	return null;
    }

    /**
     * 从数据库里获取所有的Thing列表。返回一个ArrayList
     * @return
     */
    public static ArrayList getAllThing() {
	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	if (conn != null) {
	    String sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Thing\" ) ) ";//get ThingL1
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Thing\" ) ) )";//get ThingL2
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Thing\" ) ) ) )";//get ThingL3
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	    sql = "select labeltext from label where resourceID in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + "  ( select subclassid from subclassof where superclassid in"
		    + " ( select id from resources where localname = \"#Thing\" ) ) ) ) )";//get ThingL4
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
		return tmplist;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} else {
	    System.out.println("Connection open error!");
	}
	return null;
    }

    /**
     * 从数据库里获取某个类及其子类的列表。这个类名由classname提供
     * @param classname
     * @return arraylist
     */
    public static ArrayList getList(String classname) {
	//把classname转换成classid
	int classid = db.GetFromOnto.getID(classname);
	ArrayList tmplist = null;
	ArrayList tmparrays = null;
	//调用getList，获取classid指定的类的子类列表。这个列表是classid列表
	tmparrays = db.GetFromOnto.getList(classid);
	//调用getLabels得到各classid的classname
	tmplist = getLabels(tmparrays);
	return tmplist;
    }

    /**
     * 从数据库里获取某个类及其子类的列表。这个类名由classid提供。返回的列表有层次结构。
     * @param classid
     * @return
     */
    public static ArrayList getList(int classid) {
	ArrayList tmplist = new ArrayList<String>();//临时列表，用于判断一个class有没有subclass
	ArrayList listToBeReturn = new ArrayList<String>();//要被返回的列表
	//先把要当前class加入到要返回的列表里
	listToBeReturn.add(classid);
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int n = 0;
	if (conn != null) {
	    //判断这个class有没有subclass
	    String sql = "select subclassid from subclassof where superclassid =" + classid;
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
		n = tmplist.size();
		//如果没有则把listToBeReturn返回 。
		if (n == 0) {
		    return listToBeReturn;
		} else {
		    //如果有subclass，则递归调用此方法来得到此类的子类列表
		    ArrayList tmp2 = new ArrayList<String>();//新的临时列表
		    for (int i = 0; i < n; i++) {
			//依次获取子类的子类
			tmp2 = getList(Integer.parseInt(tmplist.get(i).toString()));
			for (int j = 0; j < tmp2.size(); j++) {
			    //把子类的子类加到listToBeReturn中
			    listToBeReturn.add(tmp2.get(j));
			}
		    }
		    return listToBeReturn;
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }

    /**
     * 查询resources表，获取localname为classname的id.资源不存在则返回-1
     * @param classname
     * @return classid
     */
    public static int getID(String classname) {
//	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
//	int n = 0;
	if (conn != null) {
	    String sql = "select id from resources where localname = \"#" + classname + "\" ";
	    System.out.println(sql);
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rs.next();
		return rs.getInt(1);
//		while (rs.next()) {
//		    tmplist.add(rs.getString(1));
//		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return -1;//类不存在则返回-1
    }

    /**
     * 查询label表，把classid数组转成Label列表
     * @param intarray
     * @return
     */
    public static ArrayList getLabels(ArrayList intarray) {

	//用于存放要返回的label列表
	ArrayList tmplist = new ArrayList<String>();

	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//获取class的个数
	int n = intarray.size();
	if (conn != null) {
	    //对每个classid查出它的相应label列表
	    for (int i = 0; i < n; i++) {
		String sql = "select labeltext from label where resourceID =" + intarray.get(i).toString();
//		System.out.println(sql);
		try {
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
			tmplist.add(rs.getString(1));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	    return tmplist;
	}
	return null;
    }

    /**
     * 查询label表，把指定的labelText转换为相应的resourceID，并返回
     * @param labelText
     * @return
     */
    public static int getresourceID(String labelText) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int n = 0;
	if (conn != null) {
	    String sql = "select resourceID from label where labelText = \"" + labelText + "\"";
//	    try {
//		sql = new String(sql.getBytes("GBK"), "UTF-8");
//	    } catch (UnsupportedEncodingException ex) {
//		Logger.getLogger(GetFromOnto.class.getName()).log(Level.SEVERE, null, ex);
//	    }
	    System.out.println(sql);
//	    try {
//		Thread.sleep(5*1000);
//	    } catch (InterruptedException e) {
//		System.out.println(e.toString());
//	    }
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
		    n = rs.getInt(1);
		    rs.close();
		    pstmt.close();
		    return n;
		}
//		while (rs.next()) {
//		    tmplist.add(rs.getString(1));
//		}
	    } catch (SQLException e) {
		e.printStackTrace();
		System.out.println("hello world");
	    }
	}
	return 0;
    }
}
