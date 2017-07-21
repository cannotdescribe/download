package com.insigma.download.controller.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insigma.download.controller.BaseController;
import com.insigma.download.service.FileLoadService;

@Controller
@RequestMapping("/file")
public class FileDownLoadController extends BaseController{
	@Autowired
	private FileLoadService fileLoadService;
	
	@RequestMapping
    @ResponseBody
    String home() {
        return "file!";
    }
	
	@RequestMapping("/{type}/{fileName}")
	public void brower(@PathVariable String type, @PathVariable String fileName, HttpServletResponse response){
		System.out.println(type+"   "+fileName);
		File file = new File("file/"+type+"/"+fileName);
		responseFile(response, fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
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
}
