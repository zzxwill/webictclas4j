package db;

import java.sql.*;

/**
 *
 * @author xuxiao
 */
public class DbConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url;// = "jdbc:mysql://219.224.167.203/xuxiao2";
    //String role = null; //�����������������չ��Ϊ��ͼȨ�޿����ã������Ƕ���root�û�����������
    private static String username;//= "root";
    private static String password;//= "";
    //һ����Ҫ������ֵ����̬
    private static Connection conn = null;

    //�����ɷ�ֹ��new����2������ʵ��
    private DbConnection() {
    }

    /**
     * ���ڻ�ȡ���ݿ����ӣ����������Ȼ���ڣ��򷵻����е����ӣ����򴴽������ӡ�
     * �������ݿ�����
     * @return
     */
    public static Connection getConnection() {
	//��� ���ӻ�û�йرգ��Ǿ�ֱ�ӷ��أ���Ȼ���ٴ���һ�����ӡ�
	if (conn != null) {
	    return conn;
	} else {
	    try {
		Class.forName(driver).newInstance();
		try {
		    url = db.GetFromXML.getDbURL();
		    username = db.GetFromXML.getDbUsername();
		    password = db.GetFromXML.getDbPassword();
//		    if ((url != null) && (username != null ) )
		    	conn = DriverManager.getConnection(url, username, password);
	//	    else {
	//	    	System.out.println("file not found");
	//	    	return null;
	//	    }
//					System.out.println(conn);//////////////////////////////////
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    } catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    return conn;
	}
    }
    /*
    //�����õ�������
    public static void main(String[] args) {
    Connection conn = getConnection();
    System.out.println(conn);
    if(conn != null){
    String sql = "SELECT * FROM consumer";
    try {
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    if(rs.last()){
    System.out.println(rs.getString(1));
    }

    if(rs.next()){
    System.out.println(rs.getString(1));
    }

    } catch (SQLException e) {
    e.printStackTrace();
    }
    }
    }
     */
    /*
    public static void main(String[] args){
    Connection conn = DbConnection.getConnection();

    System.out.println(conn);
    if(conn != null){
    String sql = "SELECT * FROM consumer";
    try {
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    if(rs.last()){
    System.out.println(rs.getString(1));
    }

    if(rs.next()){
    System.out.println(rs.getString(1));
    }

    } catch (SQLException e) {
    e.printStackTrace();
    }
    }
    }
     */
}
