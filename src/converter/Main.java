package converter;

import converter.converting_data;
import converter.converter_gui;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean a_number = false;
        converting_data converter_data = new converting_data();
        converter_gui gui = new converter_gui();
        Scanner reader = new Scanner(System.in);

        System.out.print("Hello and welcome!\n This is a program for converting currency.\n choose currency that you want to convert to (write: EUR for Euro, RUB for Russian Ruble, USD for US Dollar, UAH for Hryvnia, JPY vor Yen, CHF for Swiss Franc, GBP for Pound Sterling) you can also exit by typing exit\n ");
        String currency_to = reader.nextLine();
        double currency_count_to = converter_data.Converter_to(currency_to);

        System.out.print("Choose the currency that u want to convert from (write: EUR for Euro, RUB for Russian Ruble, USD for US Dollar, UAH for Hryvnia, JPY vor Yen, CHF for Swiss Franc, GBP for Pound Sterling) you can also exit by typing exit\n");
        String currency_from = reader.nextLine();
        double currency_count_from = converter_data.Converter_from(currency_from);
                do {
                    try {
                        System.out.print("Choose how much do u want to convert\n");
                        String currency_amount_str = reader.nextLine();
                        double currency_amount = Double.parseDouble(currency_amount_str);

                        converter_data.Converter_counter(currency_amount, currency_count_to, currency_count_from);
                        a_number = true;
                    } catch (NumberFormatException e) {
                        System.out.println("\n Please write a number");

                    }
                }while(!a_number);
    }
}