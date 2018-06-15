package com.dointhai.rezonance.bean;

/**
 *
 * @author suthatronglong
 */
public enum AWSEnum {
    
    DATE_TIME(0),
    WIND_SPEED(1),
    WIND_DIRECTION(2),
    WIND_DIRECTION_TEXT(3),
    GUST_SPEED(4),
    GUST_DIRECTION(5),
    GUST_DIRECTION_TEXT(6),
    TEMPERATURE(7),
    PRECIPITATION(8),
    PRESSURE(9),
    HUMIDITY(10);
    
    int index;
    
    AWSEnum(int index) {
         this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
}
