package com.insigma.download.controller;

import javax.servlet.http.HttpServletResponse;

public class BaseController {
	public void responseFile(HttpServletResponse response, String fileName){
		response.setHeader("content-type", "application/octet-stream");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
	}
	
}
