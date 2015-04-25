package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

import com.google.gson.Gson;

import models.IWorkflowMeta;
import models.dao.IWorkflowDAO;
import models.dao.IWorkflowMetaDAO;
import sql.dao.WorkflowDAO;
import sql.dao.WorkflowMetaDAO;

public class RecommendController extends Controller {

	public static Result getTopTenWorkflow(){
		IWorkflowDAO wfd = new WorkflowDAO();
		IWorkflowMetaDAO wmd = new WorkflowMetaDAO();
		wmd.getTopTenWorkflow();
		
		String ret = new String();
		ret = new Gson().toJson(wmd);
		return ok(ret);
		
	}
	
	
	
	
//    public static Result getWorkflowMetaById(long id){
//    	IWorkflowMetaDAO wmd = new WorkflowMetaDAO();
//    	IWorkflowMeta wm = wmd.getWorkflowMeta(id);    	
//    	String ret = new String();
//    	ret = new Gson().toJson(wm);
//    	return ok(ret);
//    }


}