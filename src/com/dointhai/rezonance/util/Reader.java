package com.dointhai.rezonance.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author suthatronglong
 */
public class Reader {
    
    private BufferedReader reader;
    private StringBuffer content; 
    
    public Reader() {
        throw new NullPointerException("Reader >>> constructor method required file path (String)");
    }
    
    public Reader(String filePath) {
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException >>> " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        } finally {
            content = new StringBuffer("");
        }
    }
    
    public void readAllLines() {
        String line;
        try {
            while((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch(IOException e) {
            System.out.println("IOException >>> " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        } finally {
            completeReading();
        }
    } 
  
    public StringBuffer getContentAfterReading() {
        return content;
    }
    
    public void completeReading() {
        try {
            reader.close();
            reader = null;
        } catch(IOException e) {
            System.out.println("IOException >>> " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        }
    }
    
}
