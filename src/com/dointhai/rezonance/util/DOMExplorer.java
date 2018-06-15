package com.dointhai.rezonance.util;

import com.dointhai.rezonance.bean.AWSData;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author suthatronglong
 */
public class DOMExplorer {
 
    private StringBuffer content;
    private Elements tables;
    private ArrayList<AWSData> awsDataCollection;
    
    public DOMExplorer() {
        throw new NullPointerException("DOMExplorer >>> constructor method required content (StringBuffer)");
    }
    
    public DOMExplorer(StringBuffer content) {
        this.content = content;
        tables = null;
        awsDataCollection = new ArrayList<>();
    }
    
    public void getAllTableData() {
        int index[] = { 0 };
        parseAllTables();
        tables.forEach((Element table) -> {
            if(table.child(0).tagName().equals("tbody")) {
                Elements rows = table.select("tr");
                rows.forEach((Element row) -> {
                    index[0] = 0;
                    AWSData awsData = new AWSData();
                    Elements cols = row.select("td");
                    cols.forEach((Element data) -> {
                        if(! data.text().trim().equals("")) {
                            switch(index[0]) {
                                case 0: awsData.setDateTime(data.text().trim()); break;
                                case 1: awsData.setWindSpeed(data.text().trim()); break;
                                case 2: awsData.setWindDirection(data.text().trim()); break;
                                case 3: awsData.setWindDirectionText(data.text().trim()); break;
                                case 4: awsData.setGustWindSpeed(data.text().trim()); break;
                                case 5: awsData.setGustWindDirection(data.text().trim()); break;
                                case 6: awsData.setGustWindDirectionText(data.text().trim()); break;
                                case 7: awsData.setTemperature(data.text().trim()); break;
                                case 8: awsData.setPrecipitation(data.text().trim()); break;
                                case 9: awsData.setPressure(data.text().trim()); break;
                                case 10: awsData.setHumidity(data.text().trim()); break;
                                default:;
                            }
                            awsDataCollection.add(awsData);
                            index[0]++;
                        }           
                    });
                });
            }
        });
    }
    
    public ArrayList<AWSData> getAwsDataCollection() {
        return awsDataCollection;
    }
    
    private Elements parseAllTables() {
        Document doc = parseContentToDOM();
        tables = doc.select("table");
        return tables;
    }
    
    private Document parseContentToDOM() {
        return Jsoup.parse(content.toString());
    }
    
}
