package controllers;

import java.lang.annotation.*;
import play.mvc.*;

@With(CatchAction.class) 
@Target({ElementType.TYPE, ElementType.METHOD}) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface Catch { 
 	boolean value() default true; 
}