
package com.dointhai.rezonance.sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author suthatronglong
 */
public class DBCreator {
    
    private final String dbUser = "root";
    private final String dbPassword= "root";
    private final String dbName = "weather_logs";
    private final String dbHost = "jdbc:mysql://localhost:3306/" + dbName;
    
    public void createConnection() {
        try(Connection dbCon = DriverManager.getConnection(dbHost, dbUser, dbPassword)) {
            
        } catch(Exception e) {
            System.out.println("Exception >>> " + e.getMessage());
        }
    }
    
}
