package dev.paintilya.quebectaxcalculator.BLL.Control;

import dev.paintilya.quebectaxcalculator.BLL.Model.TaxBracket;
import dev.paintilya.quebectaxcalculator.DAL.ITaxBracketDAO;

import java.util.*;

public class QuebecTaxController {

    private ITaxBracketDAO taxBracketDAO;

    public QuebecTaxController(ITaxBracketDAO taxBracketDAO) {
        this.taxBracketDAO = taxBracketDAO;
    }

    public Map<String, Double> calculateTax(double netIncome) {
        double tax = 0d;
        double highestRate = 0d;

        for (TaxBracket bracket : taxBracketDAO.findAll()) {
            if (netIncome > bracket.getMax()) {
                tax += (bracket.getMax() - bracket.getMin()) * bracket.getRate();
                highestRate = bracket.getRate();
            } else {
                tax += (netIncome - bracket.getMin()) * bracket.getRate();
                highestRate = bracket.getRate();
                break;
            }
        }

        Map<String, Double> response = new HashMap<>();
        response.put("tax", tax); response.put("highestRate", highestRate);
        return response;
    }
}