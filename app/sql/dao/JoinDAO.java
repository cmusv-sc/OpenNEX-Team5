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


public class JoinDAO {

	private Connection connection;
	
	public JoinDAO() {

		if(DBConnector.connection == null) {
			DBConnector connector = new DBConnector();
			connector.getConnection();
		}	
	}
	
	
	public List<String> getTopXIdsByTag(String tag, int x){
//		String sql = "select distinct  workflowmeta.workflowmeta_id from `RecommendationDB`.workflowmeta inner join `RecommendationDB`.tag on workflowmeta.workflowmeta_id = tag.workflowmeta_id where tag.tag like ? order by workflowmeta.count desc limit ?";
		String sql = "select distinct  workflowmeta.workflowmeta_id from `RecommendationDB`.workflowmeta  where tag like ? order by workflowmeta.count desc limit ?";
		
		connection = DBConnector.connection;
		List<String> ids = new ArrayList<String>();
		try{
			PreparedStatement pre;
			pre = connection.prepareStatement(sql);
			pre.setString(1, "%"+tag+"%");
			pre.setInt(2, x);
			
			
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
