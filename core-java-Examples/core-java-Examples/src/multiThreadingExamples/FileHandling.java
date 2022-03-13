package multiThreadingExamples;

import java.io.*;
public class FileHandling {
	
	public String readFile() {
		StringBuffer fileData = null;
		try {
			BufferedReader br= new BufferedReader(new FileReader(new File("d://myfile.txt")));
			String data;
			while((data = br.readLine()) != null) {
				fileData.append(data);
			}
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("Error: " + fnfe);
		} catch(IOException ioe) {
			System.out.println("Error: " + ioe);
		}  catch(Exception e) {
			System.out.println(e);
		}
			return fileData.toString();
		
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br= new BufferedReader(new FileReader(new File("d://myfile.txt")));
			StringBuffer fileData = null;
			String data;
			while((data = br.readLine()) != null) {
				fileData.append(data);
			}
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("Error: " + fnfe);
		} catch(IOException ioe) {
			System.out.println("Error: " + ioe);
		}  catch(Exception e) {
			System.out.println(e);
		}
	}
}
