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
 *��������ڴӱ������ݿ��л�ȡ��Ҫ�Ķ���
 * @author xuxiao
 */
public class GetFromOnto {

    /**
     * �����ݿ��л�ȡ����Aciton���б�����һ��ArrayList
     * @return
     */
    public static ArrayList getAllAction() {
	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
//	System.out.println(conn);
	if (conn != null) {
	    /**�Ȱѵ�һ����ACTION��DB��ȡ��������ACTIONһ��һ���ش�DB��ȡ���������δ���ARRAYLIST����ɺ󷵻�List**/
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
	    /**ȡ�ڶ���ACTION**/
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
	    /**ȡ������ACTION**/
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
     * �����ݿ��л�ȡ����Event���б�����һ��ArrayList
     * @return
     */
    public static ArrayList getAllEvent() {
	ArrayList tmplist = new ArrayList<String>();
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	if (conn != null) {
	    /**
	     * �Ȱѵ�һ����EVENT��DB��ȡ����������ARRAYLIST����ɺ󷵻�List
	     *EVENTֻ��һ��*/
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
     * �����ݿ��л�ȡ���е�Entity�б�����һ��ArrayList
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
     * �����ݿ����ȡ���е�Thing�б�����һ��ArrayList
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
     * �����ݿ����ȡĳ���༰��������б����������classname�ṩ
     * @param classname
     * @return arraylist
     */
    public static ArrayList getList(String classname) {
	//��classnameת����classid
	int classid = db.GetFromOnto.getID(classname);
	ArrayList tmplist = null;
	ArrayList tmparrays = null;
	//����getList����ȡclassidָ������������б�����б���classid�б�
	tmparrays = db.GetFromOnto.getList(classid);
	//����getLabels�õ���classid��classname
	tmplist = getLabels(tmparrays);
	return tmplist;
    }

    /**
     * �����ݿ����ȡĳ���༰��������б����������classid�ṩ�����ص��б��в�νṹ��
     * @param classid
     * @return
     */
    public static ArrayList getList(int classid) {
	ArrayList tmplist = new ArrayList<String>();//��ʱ�б������ж�һ��class��û��subclass
	ArrayList listToBeReturn = new ArrayList<String>();//Ҫ�����ص��б�
	//�Ȱ�Ҫ��ǰclass���뵽Ҫ���ص��б���
	listToBeReturn.add(classid);
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int n = 0;
	if (conn != null) {
	    //�ж����class��û��subclass
	    String sql = "select subclassid from subclassof where superclassid =" + classid;
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    tmplist.add(rs.getString(1));
		}
		n = tmplist.size();
		//���û�����listToBeReturn���� ��
		if (n == 0) {
		    return listToBeReturn;
		} else {
		    //�����subclass����ݹ���ô˷������õ�����������б�
		    ArrayList tmp2 = new ArrayList<String>();//�µ���ʱ�б�
		    for (int i = 0; i < n; i++) {
			//���λ�ȡ���������
			tmp2 = getList(Integer.parseInt(tmplist.get(i).toString()));
			for (int j = 0; j < tmp2.size(); j++) {
			    //�����������ӵ�listToBeReturn��
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
     * ��ѯresources����ȡlocalnameΪclassname��id.��Դ�������򷵻�-1
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
	return -1;//�಻�����򷵻�-1
    }

    /**
     * ��ѯlabel����classid����ת��Label�б�
     * @param intarray
     * @return
     */
    public static ArrayList getLabels(ArrayList intarray) {

	//���ڴ��Ҫ���ص�label�б�
	ArrayList tmplist = new ArrayList<String>();

	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//��ȡclass�ĸ���
	int n = intarray.size();
	if (conn != null) {
	    //��ÿ��classid���������Ӧlabel�б�
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
     * ��ѯlabel����ָ����labelTextת��Ϊ��Ӧ��resourceID��������
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
