package com.example.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Marker Annotation is one that does not contain any body.
//Having 1 data -> Single Value Annotation
//More than 1 data -> Multi Value Annotation

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface customAnnotation{
	String name() default "custom";
	int id() default 6;
}

@customAnnotation(name = "newAnnotation", id = 6)
public class CustomAnnotationNew {

}
