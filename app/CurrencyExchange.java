package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class CurrencyExchange {

    ArrayList<FXratio> fxRatios = new ArrayList<>();
    public CurrencyExchange() {
    }
    public void loadCurrencyExchangeRatios() throws FileNotFoundException {
        //getting the ratios from config file
        String file = "config.json";
        Scanner scanner = new Scanner(new File(file));

        int pair = 0;
        String baseC = "";
        String finalC = "";
        double ratio;

        while(scanner.hasNextLine()) {
            String ln = scanner.nextLine().replaceAll("\\s+","");

            if (ln.charAt(0) != '[' && ln.charAt(0) != '{'  && ln.charAt(0) != '}' && ln.charAt(0) != ']') {
                pair++;
                String[] splitLine = ln.split("\"");
                if (pair == 1) {
                    baseC = splitLine[3];
                } else if (pair == 2) {
                    finalC = splitLine[3];
                } else if (pair == 3) {
                    ratio = Double.parseDouble(splitLine[3]);
                    fxRatios.add(new FXratio(baseC, finalC, ratio));
                    pair = 0;
                }
            }
        }

    }

    public double exchangeCurrency(String [] args) {

        //straightforward exchange
        for (FXratio fXratio : fxRatios) {
            if (fXratio.getBaseCurrency().equals(args[1]) && fXratio.getFinalCurrency().equals(args[2])) {
                return (Double.parseDouble(args[0]) * fXratio.getRate());
            }
        }

        //forwarded exchange
        double midValue = 0.0;
        for (FXratio ratio : fxRatios) {
            if (ratio.getBaseCurrency().equals(args[1]) && ratio.getFinalCurrency().equals("USD")) {
                midValue = Double.parseDouble(args[0]) * ratio.getRate();
            }
        }

        for (FXratio fxRatio : fxRatios) {
            if (fxRatio.getBaseCurrency().equals("USD") && fxRatio.getFinalCurrency().equals(args[2])) {
                return (midValue * fxRatio.getRate());
            }
        }

        return -1;

    }
}
