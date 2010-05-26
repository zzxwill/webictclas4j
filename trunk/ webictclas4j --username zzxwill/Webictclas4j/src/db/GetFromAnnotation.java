/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;

/**
 *
 * @author xuxiao
 */
public class GetFromAnnotation {

    /**
     * 判断数据库里有没有指定的Video,有则返回VideoID，无则返回0.
     * @param videoURL
     * @return
     */
    public static int hasVideo(String videoURL) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select videoid from t_video where videoURL = \"" + videoURL + "\"";
	System.out.println(sql);
	if (conn != null) {
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next() && (rs.getInt(1) != 0)) {
		    return rs.getInt(1);
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return 0;
    }

    /**
     * 判断数据库里有没有指定的Event,有则返回EventID，无则返回0.
     * @param eventName
     * @param videoID
     * @return
     */
    public static int hasEvent(String eventName, String videoID) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select eventID from t_event where (eventName = \"" + eventName + "\") and (videoID = " + videoID + ")";
	if (conn != null) {
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next() && (rs.getInt(1) != 0)) {
		    return rs.getInt(1);
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return 0;
    }

    /**
     * 判断数据库里有没有指定的action-object记录，有返回真，无返回假。
     * @param eventID
     * @param agentID
     * @param targetID
     * @return
     */
    public static boolean hasAO(String eventID, String agentID, String targetID) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from r_ao where (eventID = "
		+ eventID + ") and (agentID = "
		+ agentID + ") and (targetID = " + targetID + ")";
	if (conn != null) {
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
		    return true;
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return false;
    }

    /**
     *
     * 判断数据库里有没有指定的object 记录，有返回现有的objectID，无返回0。
     * @param objectName
     * @param videoID
     * @return
     */
    public static int hasObject(String objectName, String videoID) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select objectID from t_object where (objectName = \"" + objectName + "\") and (videoID = " + videoID + ")";
	if (conn != null) {
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next() && (rs.getInt(1) != 0)) {
		    return rs.getInt(1);
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return 0;
    }

    /**
     * 判断数据库里有没有指定的帧。有返回frameID，无返回 0。一个video，一个offset的帧只能有一个。
     * @param offset
     * @param videoID
     * @return
     */
    public static int hasFrame(String offset, String videoID) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select frameID from t_frame where (offset = " + offset + ") and (videoID = " + videoID + ")";
	if (conn != null) {
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();//执行sql语句
		if (rs.next() && (rs.getInt(1) != 0)) {
		    return rs.getInt(1);
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return 0;
    }

    /**
     * 判断数据库里有没有指定的frame-object记录。有返回真，无返回假。
     * @param frameID
     * @param objectID
     * @return
     */
    public static boolean hasFO(String frameID, String objectID) {
	Connection conn = db.DbConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from r_fo where (frameID = "
		+ frameID + ") and (objectID = " + objectID + ")";
	if (conn != null) {
	    try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
		    return true;
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return false;
    }

    /**
     * 判断数据库里有没有指定的event-event记录
     * @param event1ID
     * @param event2ID
     */
    public static void hasEE(String event1ID, String event2ID) {
    }
}
