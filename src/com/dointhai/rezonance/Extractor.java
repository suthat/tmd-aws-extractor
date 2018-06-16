package com.dointhai.rezonance;

import com.dointhai.rezonance.bean.AWSData;
import com.dointhai.rezonance.sql.DBCreator;
import com.dointhai.rezonance.util.Reader;
import com.dointhai.rezonance.util.DOMExplorer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author suthatronglong
 */
public class Extractor {
    
    private static final String targetDirPath = "/Users/suthatronglong/Desktop/tmd-aws-chan";
    private static DBCreator db = new DBCreator();
    
    public static void main(String args[]) {
        try {
            db.createConnection();
            Files.list(Paths.get(targetDirPath))
                .filter(Files::isRegularFile)
                .forEach((file) -> {
                    System.out.println(file.getFileName());
                    // Sample file name: reports_minute_2010-01-01 00_01_2010-01-01 24_00.xls
                    String date = file.getFileName().toString().split("_")[2];
                    date = date.split(" ")[0];
                    //System.out.println(date);
                    extractorToObject(targetDirPath + "/" + file.getFileName(), date);
                });
            db.closeConnection();
        }catch(IOException e) {
            System.out.println("FileNotFoundException >>> " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        }
    }
    
    public static void extractorToObject(String pathToFile, String date) {
        Reader reader = new Reader(pathToFile);
        reader.readAllLines();
        StringBuffer content = reader.getContentAfterReading();
        //System.out.println(content);
        DOMExplorer explorer = new DOMExplorer(content);
        explorer.getAllTableData();  
        ArrayList<AWSData> awsDataCollection = explorer.getAwsDataCollection();
        awsDataCollection.forEach((data) -> {
            System.out.println(data.toString());
            insertToDB(data, date);
        });
    }
    
    public static void insertToDB(AWSData data, String date) {
        db.insert(data, date);
    }
    
}
