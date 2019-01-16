package main.com.rest.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadTeraformJar {
	 public static void main(String[] args) {

	        //String src = "ftp://ftp.arin.net/pub/stats/arin/delegated-arin-extended-latest";
	       // String todestFile = "C:\\Users\\JayatiNaik\\eclipse-workspace\\restful-api\\WebContent\\j.txt";

	        File srcFolder = new File("C:\\Users\\JayatiNaik\\test");
	    	File destFolder = new File("C:\\Users\\JayatiNaik\\test-new");
	        
	        if(srcFolder.isDirectory()){
	        	//list all the directory contents
	    		String files[] = srcFolder.list();
	    		
	    		for (String file : files) {
	    		   //construct the src and dest file structure
	    		   File srcFile = new File(srcFolder, file);
	    		   File destFile = new File(destFolder, file);
	    		   //recursive copy
	    		   copyFolder(srcFile,destFile);
	    		}
	        } else { 
	        	copyFolder(srcFolder, destFolder);
		       }       
	    }
	 
	 
	 public static void copyFolder(File src, File dest) {
		 try {

	            //connectionTimeout, readTimeout = 10 seconds
	            //FileUtils.copyURLToFile(new URL(srcFolder), new File(destFolder), 1000000, 1000000);
			 
			 InputStream in = new FileInputStream(src);
 	        OutputStream out = new FileOutputStream(dest); 
 	                     
 	        byte[] buffer = new byte[1024];
 	    
 	        int length;
 	        //copy the file content in bytes 
 	        while ((length = in.read(buffer)) > 0){
 	    	   out.write(buffer, 0, length);
 	        }

 	        in.close();
 	        out.close();
 	        System.out.println("File copied from " + src + " to " + dest);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}


	