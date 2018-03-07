package com.insigma.download.utils;

import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebResourceFile {
    private String path;
    private File file;

    public WebResourceFile(HttpServletRequest request){
        String p = getUrl(request.getRequestURI());
        ClassPathResource classPathResource = new ClassPathResource(p);
        try {
            this.file = classPathResource.getFile();
            this.path = file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebResourceFile(File file){
        this.file = file;
        this.path = file.getPath();
    }

    public boolean exists(){
        return file !=null && file.exists();
    }

    public boolean isDirectory(){
        return file !=null && file.exists() && file.isDirectory();
    }

    public List<WebResourceFile> getAllFile(){
        if(isDirectory()){
            File[] files = file.listFiles();
            List<WebResourceFile> listFile = new ArrayList<WebResourceFile>();
            for(File file : files){
                listFile.add(new WebResourceFile(file));
            }
            return listFile;
        }else{
            try {
                throw new FileNotFoundException("文件夹不存在。");
            } catch (FileNotFoundException e) {
                return null;
            }
        }
    }

    public List<String> getAllWebRootFilePath(){
        List<String> a = new ArrayList<String>();
        for(WebResourceFile f : getAllFile()){
            a.add(f.getWebRootFilePath());
        }
        return a;
    }

    public String getWebRootFilePath(){
        int index = path.lastIndexOf("classes");
        return path.substring(index + 7, path.length());
    }

    public String getName(){
        return file.getName();
    }

    public File getFile(){
        return file;
    }

    private String getUrl(String url){
        int index = url.indexOf("/");
        if(index==0){
            return url.substring(1, url.length());
        }else{
            return url;
        }
    }
}
