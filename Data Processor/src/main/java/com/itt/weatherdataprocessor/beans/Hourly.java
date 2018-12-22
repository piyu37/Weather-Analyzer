
package com.itt.weatherdataprocessor.beans;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author kratiyag.gupta
 */

@Entity
@Table(name = "hoursData")
public class Hourly {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hourlyStatusId;
    @Column
    private int time;
    @Column
    private int tempC;
    @Column
    private int tempF;
    @Column
    private int windspeedMiles;
    @Column
    private int windspeedKmph;
    @Column
    private int winddirDegree;
    @Column
    private String winddir16Point;
    @Column
    private int humidity;
    @Column
    private int visibility;
    @Column
    private int pressure;
    @Column
    private int cloudcover;
    @Column
    private int HeatIndexC;
    @Column
    private int HeatIndexF;
    @Column
    private int DewPointC;
    @Column
    private int DewPointF;
    @Column
    private int WindChillC;
    @Column
    private int WindChillF;
    @Column
    private int WindGustMiles;
    @Column
    private int WindGustKmph;
    @Column
    private int FeelsLikeC;
    
    @Column
    private int FeelsLikeF;
    
    @ManyToOne
    @JoinColumn(name = "weatherId")
    Weather weather;

    public int getHourlyStatusId() {
        return hourlyStatusId;
    }

    public void setHourlyStatusId(int hourlyStatusId) {
        this.hourlyStatusId = hourlyStatusId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTempC() {
        return tempC;
    }

    public void setTempC(int tempC) {
        this.tempC = tempC;
    }

    public int getTempF() {
        return tempF;
    }

    public void setTempF(int tempF) {
        this.tempF = tempF;
    }

    public int getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(int windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public int getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(int windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public int getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(int winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(int cloudcover) {
        this.cloudcover = cloudcover;
    }

    public int getHeatIndexC() {
        return HeatIndexC;
    }

    public void setHeatIndexC(int HeatIndexC) {
        this.HeatIndexC = HeatIndexC;
    }

    public int getHeatIndexF() {
        return HeatIndexF;
    }

    public void setHeatIndexF(int HeatIndexF) {
        this.HeatIndexF = HeatIndexF;
    }

    public int getDewPointC() {
        return DewPointC;
    }

    public void setDewPointC(int DewPointC) {
        this.DewPointC = DewPointC;
    }

    public int getDewPointF() {
        return DewPointF;
    }

    public void setDewPointF(int DewPointF) {
        this.DewPointF = DewPointF;
    }

    public int getWindChillC() {
        return WindChillC;
    }

    public void setWindChillC(int WindChillC) {
        this.WindChillC = WindChillC;
    }

    public int getWindChillF() {
        return WindChillF;
    }

    public void setWindChillF(int WindChillF) {
        this.WindChillF = WindChillF;
    }

    public int getWindGustMiles() {
        return WindGustMiles;
    }

    public void setWindGustMiles(int WindGustMiles) {
        this.WindGustMiles = WindGustMiles;
    }

    public int getWindGustKmph() {
        return WindGustKmph;
    }

    public void setWindGustKmph(int WindGustKmph) {
        this.WindGustKmph = WindGustKmph;
    }

    public int getFeelsLikeC() {
        return FeelsLikeC;
    }

    public void setFeelsLikeC(int FeelsLikeC) {
        this.FeelsLikeC = FeelsLikeC;
    }

    public int getFeelsLikeF() {
        return FeelsLikeF;
    }

    public void setFeelsLikeF(int FeelsLikeF) {
        this.FeelsLikeF = FeelsLikeF;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }
}
