package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class CurrencyExchange {


    public CurrencyExchange() {
    }


    public double exchangeCurrency(Double amount, String baseCurrency, String finalCurrency, ArrayList<FXratio> exchangeRatios) {

        //straightforward exchange
        for (FXratio fXratio : exchangeRatios) {
            if (fXratio.getBaseCurrency().equals(baseCurrency) && fXratio.getFinalCurrency().equals(finalCurrency)) {
                return (amount * fXratio.getRate());
            }
        }

        //forwarded exchange
        double midValue = 0.0;
        for (FXratio ratio : exchangeRatios) {
            if (ratio.getBaseCurrency().equals(baseCurrency) && ratio.getFinalCurrency().equals("USD")) {
                midValue = amount * ratio.getRate();
            }
        }

        for (FXratio fxRatio : exchangeRatios) {
            if (fxRatio.getBaseCurrency().equals("USD") && fxRatio.getFinalCurrency().equals(finalCurrency)) {
                return (midValue * fxRatio.getRate());
            }
        }

        return -1;

    }
}
