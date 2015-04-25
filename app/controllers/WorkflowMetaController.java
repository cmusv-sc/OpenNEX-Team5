package controllers;

import play.*;
import play.mvc.*;
import views.html.*;


import com.google.gson.Gson;

import models.IWorkflowMeta;
import models.dao.IWorkflowMetaDAO;
import sql.dao.WorkflowMetaDAO;

public class WorkflowMetaController extends Controller {


    public static Result getWorkflowMetaById(long id){
    	IWorkflowMetaDAO wmd = new WorkflowMetaDAO();
    	IWorkflowMeta wm = wmd.getWorkflowMeta(id);    	
    	String ret = new String();
    	ret = new Gson().toJson(wm);
    	return ok(ret);
    }


}