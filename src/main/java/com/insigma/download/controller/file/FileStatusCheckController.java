package com.insigma.download.controller.file;

import com.insigma.download.entity.ResultEndBean;
import com.insigma.download.utils.FileCommon;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/filestatus")
public class FileStatusCheckController {
    @ResponseBody
    @RequestMapping("/types")
    public List<String> getTypes(HttpServletRequest request){
        ClassPathResource classPathResource = new ClassPathResource("file");
        File file = null;
        try {
            file = classPathResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileCommon.getAllFilePath(file);
    }

    @ResponseBody
    @RequestMapping("/addtype")
    public ResultEndBean addType(String type){
        ClassPathResource classPathResource = new ClassPathResource("file");
        String path = "";
        try {
            File file = classPathResource.getFile();
            path += file.getPath()+"\\"+type;
        } catch (IOException e) {
            e.printStackTrace();
        }
        File f = new File(path);
        if(FileCommon.exists(f)){
            return new ResultEndBean(false, "文件存在");
        }else{
            boolean blnExist = FileCommon.createDirectory(new File(path));
            if(blnExist){
                return new ResultEndBean();
            }else{
                return new ResultEndBean(false, "创建失败");
            }
        }
    }

    @ResponseBody
    @RequestMapping("/addfile")
    public ResultEndBean addFile(String file){
        return new ResultEndBean();
    }
}
