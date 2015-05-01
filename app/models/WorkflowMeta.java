package models;

import javax.persistence.Entity;

import com.google.gson.annotations.Expose;

import play.data.validation.*;
import play.db.ebean.Model;

@Entity
public class WorkflowMeta extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Constraints.Required(groups = {Create.class, Update.class})
	@Expose
	public String workflow_id;
	
	public String tags;
	
	public static Finder<String,WorkflowMeta> find = new Finder<String,WorkflowMeta>(String.class, WorkflowMeta.class);
	
	public interface Create { }
	public interface Update { }
	
}
