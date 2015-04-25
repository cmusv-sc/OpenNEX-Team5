package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import java.util.List;

import com.google.gson.Gson;

import models.IWorkflow;
import models.dao.IWorkflowDAO;
import sql.dao.WorkflowDAO;

public class WorkflowController extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public static Result getWorkflowByKeyword(String keyword){
    	IWorkflowDAO wd = new WorkflowDAO();
    	List<IWorkflow> wfArr = wd.getWorkflowByKeyword(keyword);
    	String ret = new String();
    	ret = new Gson().toJson(wfArr.subList(0, 10));
    	return ok(ret);
    }


}