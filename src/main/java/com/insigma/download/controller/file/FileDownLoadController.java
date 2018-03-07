package com.insigma.download.controller.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insigma.download.entity.FileResultBean;
import com.insigma.download.utils.HtmlUtil;
import com.insigma.download.utils.RequestUtils;
import com.insigma.download.utils.WebResourceFile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insigma.download.controller.BaseController;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("list")
public class FileDownLoadController extends BaseController{

    public void sendPath(HttpServletRequest request, HttpServletResponse response, WebResourceFile webResourceFile){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("nowPath", webResourceFile.getWebRootFilePath());

        List<WebResourceFile> fileList = webResourceFile.getAllFile();
        List<FileResultBean> frbs = new ArrayList<FileResultBean>();
        for(WebResourceFile f : fileList){
            if(webResourceFile.isDirectory()){
                frbs.add(new FileResultBean(f.getWebRootFilePath(), f.getName(), true));
            }else{
                frbs.add(new FileResultBean(f.getWebRootFilePath(), f.getName(), false));
            }
        }
        result.put("childrenPath", frbs);
        System.out.println("---result--->" + result);
        HtmlUtil.writerJson(response, result);
    }

    public void sendFile(HttpServletRequest request, HttpServletResponse response, WebResourceFile webResourceFile){
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            responseFile(response, webResourceFile.getName());
            byte[] buff = new byte[1024];
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(webResourceFile.getFile()));
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

	@RequestMapping("/**")
	public void brower(HttpServletRequest request, HttpServletResponse response){
        WebResourceFile webResourceFile = new WebResourceFile(request);

        if(webResourceFile.isDirectory()){
            sendPath(request, response, webResourceFile);
        }else if(webResourceFile.exists()){
            sendFile(request, response, webResourceFile);
        }else{
            //TODO 路径不存在
        }
	}

}
