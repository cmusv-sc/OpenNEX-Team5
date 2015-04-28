package models.dao;

import java.util.List;

import models.IWorkflowMeta;

public interface IWorkflowMetaDAO {
	
	public List<String> getTopXIdsByTag(String tag, int x);
	public IWorkflowMeta getWorkflowMeta(String id);

}
