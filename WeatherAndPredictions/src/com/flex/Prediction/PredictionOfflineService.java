package com.flex.Prediction;

import com.flex.Info;
import com.flex.OperationInfo;
import com.flex.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;

public class PredictionOfflineService extends Service implements PredictionService {
    private PredictionUI view;
    private PredictionGenerator generator;
    private OperationInfo operationInfo;

    public PredictionOfflineService(PredictionUI view) throws IOException, ParserConfigurationException, SAXException {
        this.view = view;
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File("predictions.xml"));

        generator = new PredictionGenerator(new PredictionParserXML(doc));
        info = new Info("Предсказания", "Предсказание по знаку", 100);
    }

    @Override
    public OperationInfo tabLastOperation() {
        return operationInfo;
    }

    @Override
    public void run() {
        view.show();
    }

    public void predictionBySign(String sign, GregorianCalendar date) {
        Prediction prediction = generator.getPrediction(sign, date);
        if (prediction == null) {
            view.showError(PredictionError.IncorrectSign);
            operationInfo = null;
        } else {
            view.showPrediction(prediction);
            operationInfo = new OperationInfo(info);
            operationInfo.time = new GregorianCalendar();
        }
    }
}