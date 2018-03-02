package com.insigma.download.controller.file;

import com.insigma.download.entity.ResultEndBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/updatefiles")
public class FileUpdateController {

    @ResponseBody
    @RequestMapping("/**")
    public ResultEndBean addFile(boolean isDir){
        if(isDir){
            return addDir();
        }else{
            return addFile();
        }
    }

    private ResultEndBean addDir(){
        return new ResultEndBean();
    }

    private ResultEndBean addFile(){
        return new ResultEndBean();
    }
}
