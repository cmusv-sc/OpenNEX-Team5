package sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.WorkflowMeta;
import models.IWorkflowMeta;
import models.dao.IWorkflowMetaDAO;

public class WorkflowMetaDAO implements IWorkflowMetaDAO {

	private Connection connection;

	@Override
	public IWorkflowMeta getWorkflowMeta(long id) {
		String sql = "select * from workflowmeta where id = ?";
		
		try {
			PreparedStatement pre;
			pre = connection.prepareStatement(sql);
			pre.setLong(1, id);

			ResultSet ret = pre.executeQuery();
			while(ret.next()) {
				WorkflowMeta meta = new WorkflowMeta();
				meta.setCount(ret.getInt("count"));
				meta.setTag(ret.getString("tag"));
				meta.setContributor(ret.getString("contributor"));
				return meta;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addWorkflowMeta(long id, String tag, int count,
			String contributor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWorkflowMeta(long id, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getTopTenWorkflow() {
		// TODO Auto-generated method stub
		
	}

}
