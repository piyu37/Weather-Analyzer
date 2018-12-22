/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itt.weatherdataprocessor.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itt.weatherdataprocessor.beans.WeatherData;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author kratiyag.gupta
 */
public class DataAnalyser {

    private String cityName;
    private String startDate;
    private String endDate;
    
    public Object getWeatherData() throws Exception {
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        URL obj = new URL("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=233ee9032a8a436ab78145436180307&q="+cityName+"&format=json&date="+startDate+"&enddate="+endDate);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        }
        in.close();
        
        WeatherData data = gson.fromJson(response.toString(), WeatherData.class);
        return data;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
