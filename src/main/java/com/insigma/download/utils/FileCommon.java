package com.insigma.download.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileCommon {

    public static List<File> getAllFile(File file){
        if(isDirectory(file)){
            File[] files = file.listFiles();
            List<File> listFile = CatUtils.parseArr(files);
            return listFile;
        }else{
            try {
                throw new FileNotFoundException("文件夹不存在。");
            } catch (FileNotFoundException e) {
                return null;
            }
        }
    }

    public static List<File> getAllFile(URL url){
        return getAllFile(url.getPath());
    }

    public static List<File> getAllFile(String path){
        File file = new File(path);
        return getAllFile(file);
    }

    public static List<String> getAllFilePath(File file){
        List<String> a = new ArrayList<String>();
        for(File f : getAllFile(file)){
            a.add(f.getName());
        }
        return a;
    }

    public static boolean isDirectory(File file){
        return file.exists() && file.isDirectory();
    }

    public static boolean exists(File file){
        return file.exists();
    }

    public static boolean createDirectory(File file){
        if(exists(file)){
            return false;
        }else{
            return file.mkdir();
        }
    }
}
