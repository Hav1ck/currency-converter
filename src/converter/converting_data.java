//all information was taken in 28.02.2024 and is not being updated
package converter;
import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;

public class converting_data {
    Scanner reader = new Scanner(System.in);
    public double euro = 1.00;
    public double euro_to_usd = 1.08;
    public double euro_to_hryvnia = 41.5;
    public double euro_to_yen = 163.16;
    public double euro_to_franc = 0.95;
    public double euro_to_pound = 0.86;
    public double euro_to_ruble = 99.1;
    public boolean gui_Interface = false;
    public String Interface = "";
    public void gui_Interface() {
        while (true){
            Interface = reader.nextLine();
            if(Interface.equalsIgnoreCase("console")) {
                gui_Interface = false;
                break;
            }
            else if(Interface.equalsIgnoreCase("gui")) {
                gui_Interface = true;
                break;
            }
            else if(Interface.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else {
                System.out.println("try again, " + Interface + " is not similar to console or gui");
            }
        }
    }

    public double Converter_to(String currency_to) {
        double currency_count_to = 0.0;
        while(true){
            if (currency_to.equalsIgnoreCase("USD")) {
                currency_count_to = euro_to_usd;
                break;
            }
            else if (currency_to.equalsIgnoreCase("UAH")) {
                currency_count_to = euro_to_hryvnia;
                break;
            }
            else if (currency_to.equalsIgnoreCase("JPY")) {
                currency_count_to = euro_to_yen;
                break;
            }
            else if (currency_to.equalsIgnoreCase("CHF")) {
                currency_count_to = euro_to_franc;
                break;
            }
            else if (currency_to.equalsIgnoreCase("GBP")) {
                currency_count_to = euro_to_pound;
                break;
            }
            else if (currency_to.equalsIgnoreCase("RUB")) {
                currency_count_to = euro_to_ruble;
                break;
            }
            else if (currency_to.equalsIgnoreCase("EUR")) {
                currency_count_to = euro;
                break;
            }
            else if (currency_to.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else {
                System.out.print("currency is not in database\n please enter the currency from the list: (write: EUR for Euro, RUB for Russian Ruble, USD for US Dollar, UAH for Hryvnia, JPY vor Yen, CHF for Swiss Franc, GBP for Pound Sterling) you can also exit by typing exit\n ");
                currency_to = reader.nextLine();
            }
        }
        return currency_count_to;
    }
    public double Converter_from(String currency_from) {
        double currency_count_from = 0.0;
        while(true){
            if (currency_from.equalsIgnoreCase("USD")) {
                currency_count_from = euro_to_usd;
                break;
            }
            else if (currency_from.equalsIgnoreCase("UAH")) {
                currency_count_from = euro_to_hryvnia;
                break;
            }
            else if (currency_from.equalsIgnoreCase("JPY")) {
                currency_count_from = euro_to_yen;
                break;
            }
            else if (currency_from.equalsIgnoreCase("CHF")) {
                currency_count_from = euro_to_franc;
                break;
            }
            else if (currency_from.equalsIgnoreCase("GBP")) {
                currency_count_from = euro_to_pound;
                break;
            }
            else if (currency_from.equalsIgnoreCase("RUB")) {
                currency_count_from = euro_to_ruble;
                break;
            }
            else if (currency_from.equalsIgnoreCase("EUR")) {
                currency_count_from = euro;
                break;
            }
            else if (currency_from.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else {
                System.out.print("currency is not in database\n please enter the currency from the list: (write: EUR for Euro, RUB for Russian Ruble, USD for US Dollar, UAH for Hryvnia, JPY vor Yen, CHF for Swiss Franc, GBP for Pound Sterling) you can also exit by typing exit\n ");
                currency_from = reader.nextLine();
            }
        }
        return currency_count_from;
    }


    public void Converter_counter(double currency_amount, double currency_count_to, double currency_count_from) {
        BigDecimal amount = BigDecimal.valueOf(currency_amount);
        BigDecimal countTo = BigDecimal.valueOf(currency_count_to);
        BigDecimal countFrom = BigDecimal.valueOf(currency_count_from);

        BigDecimal converter_result = amount.multiply(countTo).divide(countFrom, RoundingMode.HALF_UP);
        System.out.print("\n" + converter_result + "\n");
    }
}