package controllers;


import models.IWorkflowMeta;
import models.dao.IWorkflowMetaDAO;
import play.mvc.Controller;
import play.mvc.Result;
import sql.dao.WorkflowMetaDAO;

import com.google.gson.Gson;


public class WorkflowMetaController extends Controller {
	
    public static Result getWorkflowMetaById(String id){
    	
    	IWorkflowMetaDAO wmd = new WorkflowMetaDAO();
    	IWorkflowMeta wm = wmd.getWorkflowMeta(id);    	
    	String ret = new String();
    	ret = new Gson().toJson(wm);
    	return ok(ret);
    }
    
    


}