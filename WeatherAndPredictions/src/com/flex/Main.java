package com.flex;

import com.flex.Prediction.PredictionOfflineService;
import com.flex.Prediction.PredictionConsoleUI;
import com.flex.Weather.WeatherOfflineService;
import com.flex.Weather.WeatherConsoleUI;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        StandardCalculator calculator = new StandardCalculator();
        Application application = new Application(calculator);
        WeatherConsoleUI serviceIO = new WeatherConsoleUI();
        WeatherOfflineService service = new WeatherOfflineService(serviceIO);
        serviceIO.setService(service);
        application.addService(service);

        MenuUI menuUI = new MenuUI(application);
        PredictionConsoleUI UI = new PredictionConsoleUI();
        PredictionOfflineService predictionService = new PredictionOfflineService(UI);
        UI.setService(predictionService);
        application.addService(predictionService);

        menuUI.show();
    }
}