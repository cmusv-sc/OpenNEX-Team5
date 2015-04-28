package sql;

import models.IWorkflowMeta;

public class WorkflowMeta implements IWorkflowMeta {
	private String id;
	private String tag;
	private int count;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}
