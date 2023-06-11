package app;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // DEBUG - Help during development.
        if (args.length == 0) args = argsForDebug();

        CurrencyExchange ce = new CurrencyExchange();

        ce.loadCurrencyExchangeRatios();

        double result = ce.exchangeCurrency(args);

        System.out.printf("%.2f%n",result);
    }
    public static String[] argsForDebug() {
        String[] arg = new String [3];
        arg[0] = "CAD";
        arg[1] = "JPY";
        arg[2] = "17.50";
        return arg;
    }
}

