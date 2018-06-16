package com.dointhai.rezonance.sql;

import com.dointhai.rezonance.bean.AWSData;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author suthatronglong
 */
public class DBCreator {
    
    private final String dbUser = "root";
    private final String dbPassword= "root";
    private final String dbName = "weather_logs";
    private final String dbHost = "jdbc:mysql://localhost:3306/" + dbName;
    private Connection dbCon;
    private DSLContext create;
    
    public DBCreator() {
        dbCon = null;
        create = null;
    }
    
    public void createConnection() {
        try {
            dbCon = DriverManager.getConnection(dbHost, dbUser, dbPassword);
            create = DSL.using(dbCon, SQLDialect.MYSQL);
        } catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        }
    }
    
    public void insert(AWSData data, String date) {
        if(data.getDateTime() != null){ 
            String dateTime[] = data.getDateTime().split(" ");
            String sql = "INSERT INTO chanthaburi_aws(of_date,at_date,at_time,wind_speed,wind_direction,wind_direction_text,gust_wind_speed,gust_wind_direction,gust_wind_direction_text,temperature,precipitation,pressure,humidity) VALUES('"+date+"','"+dateTime[0]+"','"+dateTime[1]+"',"+data.getWindSpeed()+","+data.getWindDirection()+",'"+data.getWindDirectionText()+"',"+data.getGustWindSpeed()+","+data.getGustWindDirection()+",'"+data.getGustWindDirectionText()+"',"+data.getTemperature()+","+data.getPrecipitation()+","+data.getPressure()+","+data.getHumidity()+");";
            Query query = create.query(sql);
            query.execute();
        }
    }
    
    public void closeConnection() {
        try {
            dbCon.close();
            dbCon = null;
        } catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        }
    }
    
}
