package main.com.rest.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author JayatiNaik
 *
 */
public class DownloadTeraformJar {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Example file url
		// String src =
		// "ftp://ftp.arin.net/pub/stats/arin/delegated-arin-extended-latest";
		// String dest =
		// "C:\\Users\\JayatiNaik\\eclipse-workspace\\restful-api\\WebContent\\j.txt";

		File src = new File("C:\\Users\\JayatiNaik\\test");
		File dest = new File("C:\\Users\\JayatiNaik\\test-new");

		// make sure source exists
		if (!src.exists()) {
			System.out.println("Source Directory does not exist.");
			// just exit
			System.exit(0);
		} else {
			try {
				copyFolder(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Done");
	}

	/**
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
				System.out.println("Directory copied from " + src + "  to " + dest);
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			System.out.println("File copied from " + src + " to " + dest);
		}
	}

}
