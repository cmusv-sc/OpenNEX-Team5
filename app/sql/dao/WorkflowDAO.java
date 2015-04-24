package sql.dao;

import sql.Workflow;
import models.IWorkflow;
import models.dao.IWorkflowDAO;

public class WorkflowDAO implements IWorkflowDAO{

	@Override
	public IWorkflow getWorkflow(String workflowId) {
		Workflow w = new Workflow();
		w.setId(workflowId);
		return w;
	}
	

}
