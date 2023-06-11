package app;
public class FXratio {

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getFinalCurrency() {
        return finalCurrency;
    }

    public Double getRate() {
        return rate;
    }

    private final String baseCurrency;
    private final String finalCurrency;
    private final Double rate;

    public FXratio(String from, String to, Double rate) {
        this.baseCurrency = from;
        this.finalCurrency = to;
        this.rate = rate;
    }
}
