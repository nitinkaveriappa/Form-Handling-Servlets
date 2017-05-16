import java.sql.*;
import java.util.ArrayList;

public class StudentDAO 
{
	public Connection getConnection()
	{
		Connection con = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} 
		catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","nudiyand","ygroas");
			
		}
		catch(SQLException e)
			{
				System.out.println("Database Connection ERROR\n");
				e.printStackTrace();
			}
		return con;
		
	}
	public void addStudent(int studentid, String name, String streetaddress, String city, String state, int zip, String telephonenumber, String email, String url, String dateofsurvey, String like, String interest, String comments, String month, String year, String recommend) throws SQLException 
	{
		Connection con = getConnection();
		String insertQuery= "INSERT INTO student(studentid, name, streetaddress, city, states, zip, telephonenumber, email, url, dateofsurvey, likes, interest, comments, months, years, recommend)"+
					"VALUES("+studentid+",'"+name+"','"+streetaddress+"','"+city+"','"+state+"',"+zip+",'"+telephonenumber+"','"+email+"','"+url+"','"+dateofsurvey+"','"+like+"','"+interest+"','"+comments+"','"+month+"','"+year+"','"+recommend+"')";
		Statement stmt1 = con.createStatement();
		stmt1.executeQuery(insertQuery);
	}
		
	public StudentBean getStudent(int student_id) throws SQLException
	{
		Connection con = getConnection();
		StudentBean sData = new StudentBean();
		String getQuery = "SELECT * FROM student WHERE studentid="+student_id; 
		Statement stmt2 = con.createStatement();
		ResultSet rs = stmt2.executeQuery(getQuery);
		if(rs.next())
		{
			sData.setStudent_id(rs.getInt("studentid"));
			sData.setStudent_name(rs.getString("name"));
			sData.setStudent_address(rs.getString("streetaddress"));
			sData.setStudent_city(rs.getString("city"));
			sData.setStudent_state(rs.getString("states"));
			sData.setStudent_zipcode(rs.getInt("zip"));
			sData.setStudent_phone(rs.getString("telephonenumber"));
			sData.setStudent_email(rs.getString("email"));
			sData.setStudent_url(rs.getString("url"));
			sData.setStudent_date(rs.getString("dateofsurvey"));
			sData.setStudent_likes(rs.getString("likes"));
			sData.setStudent_interest(rs.getString("interest"));
			sData.setStudent_comments(rs.getString("comments"));
			sData.setStudent_months(rs.getString("months"));
			sData.setStudent_years(rs.getString("years"));
			sData.setStudent_recommend(rs.getString("recommend"));
		}
		return sData;
	}
	
	public ArrayList<Integer> StudentList() throws SQLException
	{
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		Connection con = getConnection();
		String listQuery = "SELECT studentid FROM student";
		Statement stmt3 = con.createStatement();
		ResultSet rs = stmt3.executeQuery(listQuery);
		
		while(rs.next())
		{
			list.add(rs.getInt("studentid"));
			i=i+1;
		}
		return list;
	}
	
}