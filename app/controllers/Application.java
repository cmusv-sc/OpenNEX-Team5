package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import play.data.Form;

import java.util.List;

import models.IWorkflow;
import models.dao.IWorkflowDAO;
import play.db.ebean.Model;
import sql.dao.WorkflowDAO;
import static play.libs.Json.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public static Result getWorkflowByKeyword(String keyword){
    	IWorkflowDAO wd = new WorkflowDAO();
    	IWorkflow wf = wd.getWorkflowByKeyword(keyword);
		return TODO;
    }
    
    public static Result recommend(){
		return TODO;
    }


}
