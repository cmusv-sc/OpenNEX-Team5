package models.dao;

import java.util.List;

import models.IWorkflow;


public interface IWorkflowDAO {

	public IWorkflow getWorkflow(long id);
	public boolean addWorkflow(long id, String title);
	public boolean updateWorkflow(long id, String title);
	public List<IWorkflow> getWorkflowByKeyword(String keyword);

}
