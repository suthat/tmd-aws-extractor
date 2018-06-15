
package com.dointhai.rezonance;

/**
 *
 * @author suthatronglong
 */
public class AWSData {
 
    private String dateTime;
    private String windSpeed;
    private String windDirection;
    private String windDirectionText;
    private String gustWindSpeed;
    private String gustWindDirection;
    private String gustWindDirectionText;
    private String temperature;
    private String precipitation;
    private String pressure;
    private String humidity;

    /**
     * @return the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the windSpeed
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return the windDirection
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * @param windDirection the windDirection to set
     */
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * @return the windDirectionText
     */
    public String getWindDirectionText() {
        return windDirectionText;
    }

    /**
     * @param windDirectionText the windDirectionText to set
     */
    public void setWindDirectionText(String windDirectionText) {
        this.windDirectionText = windDirectionText;
    }

    /**
     * @return the gustWindSpeed
     */
    public String getGustWindSpeed() {
        return gustWindSpeed;
    }

    /**
     * @param gustWindSpeed the gustWindSpeed to set
     */
    public void setGustWindSpeed(String gustWindSpeed) {
        this.gustWindSpeed = gustWindSpeed;
    }

    /**
     * @return the gustWindDirection
     */
    public String getGustWindDirection() {
        return gustWindDirection;
    }

    /**
     * @param gustWindDirection the gustWindDirection to set
     */
    public void setGustWindDirection(String gustWindDirection) {
        this.gustWindDirection = gustWindDirection;
    }

    /**
     * @return the gustWindDirectionText
     */
    public String getGustWindDirectionText() {
        return gustWindDirectionText;
    }

    /**
     * @param gustWindDirectionText the gustWindDirectionText to set
     */
    public void setGustWindDirectionText(String gustWindDirectionText) {
        this.gustWindDirectionText = gustWindDirectionText;
    }

    /**
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the precipitation
     */
    public String getPrecipitation() {
        return precipitation;
    }

    /**
     * @param precipitation the precipitation to set
     */
    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * @return the pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    
    @Override
    public String toString() {
        return "dateTime: " + dateTime + "\n" +
                "windSpeed: " + windSpeed + "\n" +
                "windDirection: " + windDirection + "\n" +
                "windDirectionText: " + windDirectionText + "\n" +
                "gustWindSpeed: " + gustWindSpeed + "\n" +
                "gustWindDirection: " + gustWindDirection + "\n" +
                "gustWindDirectionText: " + gustWindDirectionText + "\n" +
                "temperature: " + temperature + "\n" +
                "precipitation: " + precipitation + "\n" +
                "pressure: " + pressure + "\n" +
                "humidity: " + humidity + "\n";
    }
    
}
