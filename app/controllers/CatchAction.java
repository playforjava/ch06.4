package controllers;

import java.util.ArrayList;
import java.util.List;

import models.*;

import play.mvc.*;
import utils.*;

public class CatchAction extends Action<Catch> { 
	
	public Result call(Http.Context ctx) { 
 		try {
   			return delegate.call(ctx); 
 		} catch(Throwable e) {
   			if (configuration.value()) {
		    	ExceptionMailer.send(e); 
			} else {
				e.printStackTrace(); 
			}
		} 
		return Results.internalServerError();
	}
}