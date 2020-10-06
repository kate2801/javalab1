package com.flex.Weather;

import com.flex.BaseParserXML;
import com.flex.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherParserXML extends BaseParserXML implements Parser<Weather> {

    public WeatherParserXML(Document doc) {
        super(doc.getDocumentElement().getElementsByTagName("weather"));
    }

    @Override
    public Weather NextElement() {
        Node node;
        if((node = super.nextChildNode()) == null)
            return null;
        Weather weather = new Weather();
        weather.description = super.getChildrenValue(node,"description");

        return weather;
    }
}
