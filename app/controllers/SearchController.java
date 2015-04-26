package controllers;


import java.util.List;

import models.IWorkflowMeta;
import models.dao.IWorkflowMetaDAO;
import play.mvc.Controller;
import play.mvc.Result;
import sql.dao.JoinDAO;
import sql.dao.WorkflowMetaDAO;

import com.google.gson.Gson;


public class SearchController extends Controller {
	
	public static Result getWorkflowIdsByTag(String tag){
		JoinDAO jd = new JoinDAO();
		List<String> ids =  jd.getTopXIdsByTag(tag, 10);
		String ret = new String();
		ret = new Gson().toJson(ids);
		return ok(ret);
	}

}