package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {

    ArrayList<FXratio> fxRatios = new ArrayList<>();
    public boolean loadCurrencyExchangeRatiosFromFile() throws FileNotFoundException {
        //getting the ratios from config file
        String file = "C:\\currConv\\config.json";
        Scanner scanner = new Scanner(new File(file));

        int lineReadingCounter = 0;
        String baseCurrency = "";
        String finalCurrency = "";
        double exchangeRatio;

        while(scanner.hasNextLine()) {
            String ln = scanner.nextLine().replaceAll("\\s+","");

            if (ln.charAt(0) != '[' && ln.charAt(0) != '{'  && ln.charAt(0) != '}' && ln.charAt(0) != ']') {
                lineReadingCounter++;
                String[] splitLine = ln.split("\"");
                if (lineReadingCounter == 1) {
                    baseCurrency = splitLine[3];
                } else if (lineReadingCounter == 2) {
                    finalCurrency = splitLine[3];
                } else if (lineReadingCounter == 3) {
                    exchangeRatio = Double.parseDouble(splitLine[3]);
                    fxRatios.add(new FXratio(baseCurrency, finalCurrency, exchangeRatio));
                    lineReadingCounter = 0;
                }
            }

        }
        if (fxRatios.size() > 0)
        {
            return true;
        }
        System.out.println("Bad config file.");
        return false;

    }
}
