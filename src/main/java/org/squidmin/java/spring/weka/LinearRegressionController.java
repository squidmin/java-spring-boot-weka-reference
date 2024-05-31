package org.squidmin.java.spring.weka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinearRegressionController {

    @Autowired
    private LinearRegressionService linearRegressionService;

    @GetMapping("/train")
    public String trainModel() {
        try {
            linearRegressionService.loadAndTrainModel("/data.csv");
            return "Model trained successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error training model: " + e.getMessage();
        }
    }

    @GetMapping("/predict")
    public double predict(@RequestParam double[] values) {
        try {
            return linearRegressionService.predict(values);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
