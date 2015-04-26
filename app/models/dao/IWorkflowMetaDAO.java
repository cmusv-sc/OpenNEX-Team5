package models.dao;

import models.IWorkflowMeta;

public interface IWorkflowMetaDAO {
	
	public boolean addWorkflowMeta(long id, String tag, int count, String contributor);
	public boolean updateWorkflowMeta(long id, int count);
	public void getTopTenWorkflow();
	public IWorkflowMeta getWorkflowMeta(String id);

}
