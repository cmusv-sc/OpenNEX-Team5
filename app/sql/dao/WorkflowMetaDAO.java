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

public class WorkflowMetaDAO implements IWorkflowMetaDAO {

	private Connection connection;

	public WorkflowMetaDAO() {
		if (DBConnector.connection == null) {
			DBConnector.getConnection();
		}
	}

	@Override
	public IWorkflowMeta getWorkflowMeta(String id) {
		String sql = "select * from `RecommendationDB`.workflowmeta where workflowmeta_id = ?";
		connection = DBConnector.connection;
		try {
			PreparedStatement pre;
			pre = connection.prepareStatement(sql);
			pre.setString(1, id);

			ResultSet ret = pre.executeQuery();
			while (ret.next()) {
				WorkflowMeta meta = new WorkflowMeta();
				meta.setId(id);
				meta.setCount(ret.getInt("count"));
				meta.setTag(ret.getString("tag"));
				return meta;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getTopXIdsByTag(String tag, int x) {
		String sql = "select distinct  workflowmeta.workflowmeta_id from `RecommendationDB`.workflowmeta  "
				+ "where tag like ? order by workflowmeta.count desc limit ?";

		connection = DBConnector.connection;
		List<String> ids = new ArrayList<String>();
		try {
			PreparedStatement pre;
			pre = connection.prepareStatement(sql);
			pre.setString(1, "%" + tag + "%");
			pre.setInt(2, x);

			ResultSet ret = pre.executeQuery();
			String id;
			while (ret.next()) {
				id = ret.getString("workflowmeta_id");
				ids.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}

}
