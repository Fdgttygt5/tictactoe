package chptr11;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyByteWriter {

  public static void main(String[] args) {

	  String txt = "my";
	  
    try (FileOutputStream myFile = new FileOutputStream("new")){         

            myFile.write(txt.getBytes());      
 
    } catch (IOException ioe) {
        System.out.println("Could not write into the file: " + ioe.getMessage());     
    }
  }
}