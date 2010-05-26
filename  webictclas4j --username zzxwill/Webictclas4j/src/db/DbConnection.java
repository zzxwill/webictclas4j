package db;

import java.sql.*;

/**
 *
 * @author xuxiao
 */
public class DbConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url;// = "jdbc:mysql://219.224.167.203/xuxiao2";
    //String role = null; //这个属性用来将来扩展作为视图权限控制用，而不是都用root用户，保留……
    private static String username;//= "root";
    private static String password;//= "";
    //一般需要这样单值，静态
    private static Connection conn = null;

    //这样可防止用new生成2个以上实例
    private DbConnection() {
    }

    /**
     * 用于获取数据库连接，如果连接仍然存在，则返回现有的连接，否则创建新连接。
     * 返回数据库连接
     * @return
     */
    public static Connection getConnection() {
	//如果 连接还没有关闭，那就直接返回，不然就再创建一个连接。
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
    //测试用的主函数
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
