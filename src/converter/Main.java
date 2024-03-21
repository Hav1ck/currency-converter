package converter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean a_number = false;
        update_checker checker = new update_checker();
        converting_data data = new converting_data();
        converter_gui gui = new converter_gui();
        Scanner reader = new Scanner(System.in);

        checker.update();

        System.out.print("Hello and welcome!\nThis is a program for converting currency.\nType gui for graphical interface or console for console based interface you can also exit by typing exit\n");

        data.gui_Interface();
        if (data.gui_Interface) {
            gui.cgui();
            System.out.println("Your gui was launched in new window.");
        }
        else if (!data.gui_Interface) {
            while(true) {
                System.out.print("Choose currency that you want to convert to (write: EUR for Euro, RUB for Russian Ruble, USD for US Dollar, UAH for Hryvnia, JPY vor Yen, CHF for Swiss Franc, GBP for Pound Sterling) you can also exit by typing exit.\n");
                String currency_to = reader.nextLine();
                double currency_count_to = data.Converter_to(currency_to);

                System.out.print("Choose the currency that you want to convert from (write: EUR for Euro, RUB for Russian Ruble, USD for US Dollar, UAH for Hryvnia, JPY vor Yen, CHF for Swiss Franc, GBP for Pound Sterling) you can also exit by typing exit.\n");
                String currency_from = reader.nextLine();
                double currency_count_from = data.Converter_from(currency_from);
                do {
                    try {
                        System.out.print("Choose how much do you want to convert.\n");
                        String currency_amount_str = reader.nextLine();
                        if (currency_amount_str.equalsIgnoreCase("exit")) {
                            System.exit(0);
                        }
                        double currency_amount = Double.parseDouble(currency_amount_str);

                        data.Converter_counter(currency_amount, currency_count_to, currency_count_from);
                        a_number = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Please write a number.");

                    }
                } while (!a_number);
            }
        }
        else {
            System.out.println("Something went wrong.");
        }

    }
}
