package dev.paintilya.quebectaxcalculator.BLL.Model;

public class TaxBracket {
    private double min, max, rate;

    public TaxBracket() {}

    public TaxBracket(double min, double max, double rate) {
        this.min = min;
        this.max = max;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "TaxBracket{" +
                "min=" + min +
                ", max=" + max +
                ", rate=" + rate +
                '}';
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
