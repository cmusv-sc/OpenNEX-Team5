package controllers;


import java.util.ArrayList;
import java.util.List;

import models.WorkflowEntry;
import models.WorkflowMeta;
import play.mvc.Controller;
import play.mvc.Result;
import sql.dao.WorkflowMetaDAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SearchController extends Controller {
	
	public static Result getWorkflowIdsByTag(String tag){
		WorkflowMetaDAO metaDAO = new WorkflowMetaDAO();
		List<String> ids =  metaDAO.getTopXIdsByTag(tag, 10);
		String ret = new String();
		ret = new Gson().toJson(ids);
		return ok(ret);
	}
	
	public static Result getWorkflowsByTag(String tag){
		List<WorkflowMeta> metas = WorkflowMeta.find.where().contains("tags", tag).findList();
		List<String> ids = new ArrayList<String>();
		for(WorkflowMeta meta : metas){
			ids.add(meta.workflow_id);
		}
		List<WorkflowEntry> workflows = WorkflowEntry.find.where().idIn(ids).findList();
		GsonBuilder builder = new GsonBuilder();
    	builder.excludeFieldsWithoutExposeAnnotation();
    	Gson gson = builder.create();
		return ok(gson.toJson(workflows));
	}

}