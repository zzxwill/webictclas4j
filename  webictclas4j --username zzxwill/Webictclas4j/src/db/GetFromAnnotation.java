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
     * �ж����ݿ�����û��ָ����Video,���򷵻�VideoID�����򷵻�0.
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
     * �ж����ݿ�����û��ָ����Event,���򷵻�EventID�����򷵻�0.
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
     * �ж����ݿ�����û��ָ����action-object��¼���з����棬�޷��ؼ١�
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
     * �ж����ݿ�����û��ָ����object ��¼���з������е�objectID���޷���0��
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
     * �ж����ݿ�����û��ָ����֡���з���frameID���޷��� 0��һ��video��һ��offset��ֻ֡����һ����
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
		rs = pstmt.executeQuery();//ִ��sql���
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
     * �ж����ݿ�����û��ָ����frame-object��¼���з����棬�޷��ؼ١�
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
     * �ж����ݿ�����û��ָ����event-event��¼
     * @param event1ID
     * @param event2ID
     */
    public static void hasEE(String event1ID, String event2ID) {
    }
}
