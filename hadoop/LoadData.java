import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;
public class LoadData {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//Statement stmt = null;
		try{
			   
			      //STEP 2: Register JDBC driver
			   Class.forName("com.mysql.jdbc.Driver");

			   System.out.println("Connecting to a selected database...");
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   System.out.println("Connected database successfully...");
			   
			   BufferedReader br = new BufferedReader(new FileReader(""));
			   String line;
			   while ((line = br.readLine()) != null) {
				   String[] linetoken = line.split("\t");
				   String id = linetoken[0];
				   int count = Integer.parseInt(linetoken[1]);
				   //check if it is exist
				   
				   String sql = "select * from `RecommendationDB`.workflowmeta where workflowmeta_id = ?";
				   PreparedStatement prest = conn.prepareStatement(sql);
				   prest.setString(1, id);
				   
				   ResultSet ret = prest.executeQuery();
				   if(ret.next()) {
					   int precount = ret.getInt("count"); 
					   count+=precount;
					   String sql1 = "UPDATE `RecommendationDB`.workflowmeta SET count="+count+" WHERE workflowmeta_id="+id;
					   Statement st1 = conn.createStatement();
					   st1.execute(sql1);
                   }else{
				   String sql2 = "INSERT INTO `RecommendationDB`.workflowmeta (workflowmeta_i, count) VALUES("+id+","+count+")";
				   Statement st2 = conn.createStatement();
                       st2.execute(sql2);}
				   
			   }
			   br.close();
			   
			      //STEP 4: Execute a query
			   
			}catch(SQLException se){
			      //Handle errors for JDBC
			   se.printStackTrace();
			}catch(Exception e){
			      //Handle errors for Class.forName
			   e.printStackTrace();
			}
	}

}
