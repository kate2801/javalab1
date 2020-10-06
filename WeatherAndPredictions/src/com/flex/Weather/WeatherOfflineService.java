package com.flex.Weather;


import com.flex.Info;
import com.flex.MoneyCalculator;
import com.flex.OperationInfo;
import com.flex.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

public class WeatherOfflineService extends Service implements WeatherService {

    private WeatherGenerator weatherGenerator;
    private WeatherUI view;
    private OperationInfo lastOperation;



    public WeatherOfflineService(WeatherUI io) throws ParserConfigurationException, IOException, SAXException {
        view = io;
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File("weather.xml"));

        weatherGenerator = new WeatherGenerator(new WeatherParserXML(doc));
        info = new Info("Погода", "Прогноз погоды", 120);
    }

    public void findWeather(GregorianCalendar first, GregorianCalendar last) {
        try {
            view.showWeatherList(weatherGenerator.getWeatherByDate(first, last), first);
            lastOperation = new OperationInfo(getInfo());
            lastOperation.time = new GregorianCalendar();
        } catch (Exception e) {
            view.showError(WeatherError.InvalidDates);
        }
    }

    @Override
    public OperationInfo tabLastOperation() {
        return lastOperation;
    }

    @Override
    public void run() {
        view.show();
    }
}
