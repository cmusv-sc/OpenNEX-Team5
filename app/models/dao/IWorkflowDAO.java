package models.dao;

import models.IWorkflow;


public interface IWorkflowDAO {

	public IWorkflow getWorkflow(long id);
	public boolean addWorkflow(long id, String title);
	public boolean updateWorkflow(long id, String title);
	public IWorkflow getWorkflowByKeyword(String keyword);

}
