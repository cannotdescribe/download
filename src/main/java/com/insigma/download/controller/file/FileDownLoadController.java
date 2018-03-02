package com.insigma.download.controller.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insigma.download.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insigma.download.controller.BaseController;
import com.insigma.download.service.FileLoadService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("/file")
public class FileDownLoadController extends BaseController{

	@RequestMapping("/{type}/{fileName}")
	public void brower(@PathVariable("type") String type, @PathVariable("fileName") String fileName,
                       HttpServletResponse response, HttpServletRequest request){
	    String fileNameAndSuffix = fileName + RequestUtils.getSuffix(request);
        ClassPathResource classPathResource = new ClassPathResource("file/"+type+"/"+fileNameAndSuffix);
        BufferedInputStream bis = null;
        OutputStream os = null;
		try {
            File file = classPathResource.getFile();
            responseFile(response, fileNameAndSuffix);
            byte[] buff = new byte[1024];
			os = response.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@RequestMapping("{type}")
	public void brower(@PathVariable("type") String type, HttpServletRequest request){
        System.out.println(type);
	}
}
