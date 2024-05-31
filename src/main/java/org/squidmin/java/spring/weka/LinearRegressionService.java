package org.squidmin.java.spring.weka;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import weka.classifiers.functions.LinearRegression;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

@Service
public class LinearRegressionService {

    private LinearRegression model;
    private Instances datasetStructure;

    public void loadAndTrainModel(String dataFilePath) throws Exception {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new ClassPathResource(dataFilePath).getInputStream());
        Instances data = loader.getDataSet();
        if (data.numInstances() == 0) {
            throw new IllegalArgumentException("No instances loaded from file: " + dataFilePath);
        }
        if (data.classIndex() == -1) { data.setClassIndex(data.numAttributes() - 1); }

        datasetStructure = new Instances(data, 0);  // Keep structure for prediction

        model = new LinearRegression();
        model.buildClassifier(data);
    }

    public double predict(double[] instanceValues) throws Exception {
        if (datasetStructure == null) {
            throw new IllegalStateException("The model has not been trained yet.");
        }

        DenseInstance newInstance = new DenseInstance(1.0, instanceValues);
        newInstance.setDataset(datasetStructure);
        return model.classifyInstance(newInstance);
    }

}
