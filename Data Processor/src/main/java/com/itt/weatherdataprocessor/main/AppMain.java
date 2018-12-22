
package com.itt.weatherdataprocessor.main;

import com.itt.weatherdataprocessor.beans.WeatherData;
import com.itt.weatherdataprocessor.configuration.DataAnalyser;
import com.itt.weatherdataprocessor.configuration.HibernateUtil;
import com.itt.weatherdataprocessor.operations.DatabaseFunctions;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kratiyag.gupta
 */
public class AppMain {

    public AppMain() throws Exception {
        Scanner in = new Scanner(System.in);
        int choice;
        DatabaseFunctions dfs = new DatabaseFunctions();
        do {
            System.out.println("Please Enter your Choice");
            System.out.println("1.Populate DB with a new city weather information");
            System.out.println("9.For Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    try {
                        DataAnalyser analyser = new DataAnalyser();
                        System.out.println("Enter city :- ");
                        analyser.setCityName(in.next());
                        System.out.println("Enter start date :-");
                        analyser.setStartDate(in.next());
                        System.out.println("Enter end date:- ");
                        analyser.setEndDate(in.next());
                        WeatherData weatherData = (WeatherData) analyser.getWeatherData();
                        for (int i = 0; i < weatherData.getData().getWeather().length; i++) {
                            weatherData.getData().getWeather()[i].setCity(analyser.getCityName());
                            dfs.insertData(weatherData.getData().getWeather()[i]);
                        }
                    }
                    catch (IOException ex) {
                        System.out.println("Process fail due to following action" + ex.getMessage());
                    }
                }
                break;
                case 9: {
                    HibernateUtil.getSessionFactory().getCurrentSession().close();
                    System.exit(0);
                }
                break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 9);
    }

    public static void main(String[] args) throws Exception {
        new AppMain();
    }
}
