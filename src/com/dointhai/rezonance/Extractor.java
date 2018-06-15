package com.dointhai.rezonance;

import com.dointhai.rezonance.util.DOMExplorer;
import com.dointhai.rezonance.util.Reader;
import java.util.ArrayList;

/**
 *
 * @author suthatronglong
 */
public class Extractor {
    
    public static void main(String args[]) {
        Reader reader = new Reader("/Users/suthatronglong/Desktop/reports_minute_2010-01-01 00_01_2010-01-01 24_00.xls");
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
