package sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnector;
import sql.WorkflowMeta;
import models.IWorkflowMeta;
import models.dao.IWorkflowMetaDAO;


public class TagDAO {

	private Connection connection;
	
	public TagDAO() {

		if(DBConnector.connection == null) {
			DBConnector connector = new DBConnector();
			connector.getConnection();
		}	
	}
	
	public List<String> getWorkflowIdsByTag(String tag){
		String sql = "select * from `RecommendationDB`.tag where tag like '%?%'";
		connection = DBConnector.connection;
		List<String> ids = new ArrayList<String>();
		try{
			PreparedStatement pre;
			pre = connection.prepareStatement(sql);
			pre.setString(1, tag);
			
			ResultSet ret = pre.executeQuery();
			String id;
			while(ret.next()){
				id = ret.getString("workflowmeta_id");
				ids.add(id);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ids;
	}

}
