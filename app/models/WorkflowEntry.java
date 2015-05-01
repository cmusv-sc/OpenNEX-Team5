package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.data.validation.*;

@Entity
public class WorkflowEntry extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	public String registryId;
	
	@Id
	@Expose
	public String workflowId;
	
	@Expose
	public String versionNo;
	
	@Expose
	public String registorId;
	
	@Expose
	public String registerTimeStamp;
	
	@Expose
	@Column(length = 1000)
	public String registerNote;
	
	public static Finder<String,WorkflowEntry> find = new Finder<String,WorkflowEntry>(String.class, WorkflowEntry.class);
	
	public interface Create { }
	public interface Update { }
	
}
