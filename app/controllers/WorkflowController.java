package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.IWorkflow;
import models.WorkflowEntry;
import models.dao.IWorkflowDAO;
import sql.dao.WorkflowDAO;

public class WorkflowController extends Controller {
    
    public static Result getWorkflowByKeyword(String keyword){
    	IWorkflowDAO wd = new WorkflowDAO();
    	List<IWorkflow> wfArr = wd.getWorkflowByKeyword(keyword);
    	String ret = new String();
    	GsonBuilder builder = new GsonBuilder();
    	builder.excludeFieldsWithoutExposeAnnotation();
    	Gson gson = builder.create();
    	ret = gson.toJson(wfArr.subList(0, 10));
    	return ok(ret);
    }

    public static Result getWorkflows(){
    	List<WorkflowEntry> workflows = WorkflowEntry.find.all();
    	GsonBuilder builder = new GsonBuilder();
    	builder.excludeFieldsWithoutExposeAnnotation();
    	Gson gson = builder.create();
		return ok(gson.toJson(workflows));
    }
    
}