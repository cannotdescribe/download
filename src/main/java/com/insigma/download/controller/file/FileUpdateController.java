package com.insigma.download.controller.file;

import com.insigma.download.entity.ResultEndBean;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Properties;

@Controller
@RequestMapping("/file/upload")
public class FileUpdateController {

    @RequestMapping(value="/uploadFile",method= RequestMethod.POST)
    public String upload(HttpServletRequest request,
                                @RequestParam("tagPath") String tagPath,
                                @RequestParam("file") MultipartFile file) throws Exception {

        System.out.println("-----存放位置----->" + tagPath);
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            Properties pro = PropertiesLoaderUtils.loadAllProperties("fileConfig.properties");

            //上传文件路径
            String path = (String) pro.get("filePath") + "/" + tagPath;
            System.out.println("------path------>" + path);
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件夹当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else {
            return "failure";
        }

    }

}
