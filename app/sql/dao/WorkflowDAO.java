package sql.dao;

import java.util.List;

import models.IWorkflow;
import models.dao.IWorkflowDAO;

public class WorkflowDAO implements IWorkflowDAO {

	@Override
	public IWorkflow getWorkflow(long id) {
		
		return null;
	}

	@Override
	public boolean addWorkflow(long id, String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWorkflow(long id, String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IWorkflow> getWorkflowByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
