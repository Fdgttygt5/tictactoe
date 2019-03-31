package chptr11;

import java.io.FileInputStream;
import java.io.IOException;

public class MyByteReader {

  public static void main(String[] args) {

    try (FileInputStream myFile =             
              new FileInputStream("new")){

      int byteValue;

      while ((byteValue = myFile.read()) != -1) { 

          System.out.print(byteValue + " ");   
      }
    } catch (IOException ioe) {               
        System.out.println("Could not read file: " +
                ioe.getMessage());
    }
  }
}