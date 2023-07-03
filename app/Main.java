package app;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // DEBUG - Help during development.
        if (args.length == 0) args = argsForDebug();

        Double exchangedAmount = Double.parseDouble(args[0]);
        String exchangedBaseCurrency = args[1];
        String exchangedFinalCurrency = args[2];

        DataLoader dl = new DataLoader();
        dl.loadCurrencyExchangeRatiosFromFile();

        CurrencyExchange ce = new CurrencyExchange();
        double result = ce.exchangeCurrency(exchangedAmount,exchangedBaseCurrency,exchangedFinalCurrency, dl.fxRatios);

        System.out.printf("%.2f%n",result);
    }
    public static String[] argsForDebug() {
        String[] arg = new String [3];
        arg[0] = "17.50";
        arg[1] = "CAD";
        arg[2] = "JPY";
        return arg;
    }
}

