package com.insigma.download.controller.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileMainController {

    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping("/download")
    public String download() {
        return "download";
    }
}
