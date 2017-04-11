package com.automation.framework.fileutils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtils {
	
	 FileInputStream fs;

	 //MakingFileObject
	public  FileInputStream readFile(String fileName) throws FileNotFoundException{
		fs = new FileInputStream(new File(fileName));
		return fs;
	}
}
