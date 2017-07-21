package com.insigma.download.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileOnloadUtil {
	public static List<File> getFileUrl(){
		File files = new File("file/brower");
		if(files.mkdirs()){
			return Arrays.asList(files.listFiles());
		}
		return null;
	}
}
