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
        arg[0] = "17.50";
        arg[1] = "CAD";
        arg[2] = "JPY";
        return arg;
    }
}

