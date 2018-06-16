package com.dointhai.rezonance.util;

import com.dointhai.rezonance.bean.AWSData;
import com.dointhai.rezonance.bean.AWSEnum;
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
                            if(index[0] == AWSEnum.DATE_TIME.getIndex()) {
                                awsData.setDateTime(data.text().trim());
                            } else if(index[0] == AWSEnum.WIND_SPEED.getIndex()) {
                                awsData.setWindSpeed(data.text().trim());
                            } else if(index[0] == AWSEnum.WIND_DIRECTION.getIndex()) {
                                awsData.setWindDirection(data.text().trim());
                            } else if(index[0] == AWSEnum.WIND_DIRECTION_TEXT.getIndex()) {
                                awsData.setWindDirectionText(data.text().trim());
                            } else if(index[0] == AWSEnum.GUST_SPEED.getIndex()) {
                                awsData.setGustWindSpeed(data.text().trim());
                            } else if(index[0] == AWSEnum.GUST_DIRECTION.getIndex()) {
                                awsData.setGustWindDirection(data.text().trim());
                            } else if(index[0] == AWSEnum.GUST_DIRECTION_TEXT.getIndex()) {
                                awsData.setGustWindDirectionText(data.text().trim());
                            } else if(index[0] == AWSEnum.TEMPERATURE.getIndex()) {
                                awsData.setTemperature(data.text().trim());
                            } else if(index[0] == AWSEnum.PRECIPITATION.getIndex()) {
                                awsData.setPrecipitation(data.text().trim());
                            } else if(index[0] == AWSEnum.PRESSURE.getIndex()) {
                                awsData.setPressure(data.text().trim());
                            } else if(index[0] == AWSEnum.HUMIDITY.getIndex()) {
                                awsData.setHumidity(data.text().trim());
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
