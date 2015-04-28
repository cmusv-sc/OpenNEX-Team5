package controllers;


import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;
import sql.dao.WorkflowMetaDAO;

import com.google.gson.Gson;


public class SearchController extends Controller {
	
	public static Result getWorkflowIdsByTag(String tag){
		WorkflowMetaDAO metaDAO = new WorkflowMetaDAO();
		List<String> ids =  metaDAO.getTopXIdsByTag(tag, 10);
		String ret = new String();
		ret = new Gson().toJson(ids);
		return ok(ret);
	}

}