package Modulo4;
import java.sql.*;

public class TitleTypes {
	public static boolean insert(Connection conn, int title_no, String title) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("INSERT INTO title_types VALUES (?,?)" );
			pst.setInt(1, title_no);
			pst.setString(2, title);
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	public static String select(Connection conn, int title_no) {
		PreparedStatement pst;
		String vret = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM title_types WHERE title_no=?" );
			pst.setInt(1, title_no);
			ResultSet rs = pst.executeQuery();
			rs.next();
			vret = rs.getInt("title_no") + ";" + rs.getString("title");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}
	
	public static boolean update(Connection conn, int title_no, String title) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("update title_types set title=? where title_no=?" );
			pst.setString(1, title);
			pst.setInt(2, title_no);
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	public static boolean delete(Connection conn, int title_no) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("delete from title_types where title_no=?" );
			pst.setInt(1, title_no);
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	
	
}
	


