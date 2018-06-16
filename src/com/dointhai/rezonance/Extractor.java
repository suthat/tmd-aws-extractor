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
    
    public static void main(String args[]) {
        DBCreator db = new DBCreator();
        db.createConnection();
//        try {
//            Files.list(Paths.get(targetDirPath))
//                    .filter(Files::isRegularFile)
//                    .forEach((file) -> {
//                        System.out.println(file.getFileName());
//                        extractorToObject(targetDirPath + "/" + file.getFileName());
//                    });
//        }catch(IOException e) {
//            System.out.println("FileNotFoundException >>> " + e.getMessage());
//        }catch(Exception e) {
//            System.out.println("Exception >>> " + e.getMessage());
//        }
    }
    
    public static void extractorToObject(String pathToFile) {
        Reader reader = new Reader(pathToFile);
        reader.readAllLines();
        StringBuffer content = reader.getContentAfterReading();
        //System.out.println(content);
        DOMExplorer explorer = new DOMExplorer(content);
        explorer.getAllTableData();  
        ArrayList<AWSData> awsDataCollection = explorer.getAwsDataCollection();
        awsDataCollection.forEach((data) -> {
            System.out.println(data.toString());
        });
    }
    
}
