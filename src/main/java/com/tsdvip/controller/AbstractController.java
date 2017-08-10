package com.tsdvip.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsdvip.util.JsonResult;


public abstract class AbstractController {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	@ResponseBody
	public JsonResult expHandle(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}

}
