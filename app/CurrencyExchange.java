package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class CurrencyExchange {


    public CurrencyExchange() {
    }


    public double exchangeCurrency(Double amount, String baseCurrency, String finalCurrency, ArrayList<FXratio> exchangeRatios) {

        if (isStraightforwardExchangePossible(baseCurrency, finalCurrency, exchangeRatios))
        {
            return straightforwardExchange(amount, baseCurrency, finalCurrency, exchangeRatios);
        }
        else if (isForwardExchangePossible(baseCurrency, finalCurrency, exchangeRatios))
        {
            return forwardExchange(amount, baseCurrency, finalCurrency, exchangeRatios);
        }

        System.out.println("Exchange impossible, no exchange data");
        return -1;
    }

    private boolean isStraightforwardExchangePossible(String currency1, String currency2, ArrayList<FXratio> exchangeRatios){
        for (FXratio fXratio : exchangeRatios) {
            if (fXratio.getBaseCurrency().equals(currency1) && fXratio.getFinalCurrency().equals(currency2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isForwardExchangePossible(String currency1, String currency2, ArrayList<FXratio> exchangeRatios){

        for (FXratio ratio : exchangeRatios) {
            if (ratio.getBaseCurrency().equals(currency1) && ratio.getFinalCurrency().equals("USD")) {
                for (FXratio fxRatio2 : exchangeRatios) {
                    if (fxRatio2.getBaseCurrency().equals("USD") && fxRatio2.getFinalCurrency().equals(currency2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double straightforwardExchange(Double amount, String baseCurrency, String finalCurrency, ArrayList<FXratio> exchangeRatios){
        for (FXratio fXratio : exchangeRatios) {
            if (fXratio.getBaseCurrency().equals(baseCurrency) && fXratio.getFinalCurrency().equals(finalCurrency)) {
                return (amount * fXratio.getRate());
            }
        }
        return -1;
    }

    private double forwardExchange(Double amount, String baseCurrency, String finalCurrency, ArrayList<FXratio> exchangeRatios){
        for (FXratio ratio : exchangeRatios) {
            if (ratio.getBaseCurrency().equals(baseCurrency) && ratio.getFinalCurrency().equals("USD")) {
                for (FXratio fxRatio2 : exchangeRatios) {
                    if (fxRatio2.getBaseCurrency().equals("USD") && fxRatio2.getFinalCurrency().equals(finalCurrency)) {
                        return (amount * ratio.getRate() * fxRatio2.getRate());
                    }
                }
            }
        }
        return -1;
    }
}