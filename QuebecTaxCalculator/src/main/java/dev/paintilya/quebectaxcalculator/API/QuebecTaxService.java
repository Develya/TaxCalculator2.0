package dev.paintilya.quebectaxcalculator.API;

import dev.paintilya.quebectaxcalculator.BLL.Control.QuebecTaxController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/qtc")
public class QuebecTaxService {
    @Autowired
    private QuebecTaxController quebecTaxController;

    @RequestMapping("/calculate")
    public @ResponseBody Object calculateTax(@RequestParam double netIncome) {
        Map<String, Double> response = quebecTaxController.calculateTax(netIncome);
        return new Object() {
            public double tax = response.get("tax");
            public double highestRate = response.get("highestRate") * 100;
        };
    }

}