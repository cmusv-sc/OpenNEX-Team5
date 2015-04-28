package controllers;

import models.dao.IWorkflowMetaDAO;
import play.mvc.Controller;
import play.mvc.Result;
import sql.dao.WorkflowMetaDAO;

import com.google.gson.Gson;

public class RecommendController extends Controller {

	public static Result getTopTenWorkflowByTag(String tag){
		IWorkflowMetaDAO wmd = new WorkflowMetaDAO();
		String ret = new String();
		ret = new Gson().toJson(wmd.getTopXIdsByTag(tag, 10));
		return ok(ret);
		
	}
	


}