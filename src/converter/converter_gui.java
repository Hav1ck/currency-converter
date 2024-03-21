package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class converter_gui {
    public JTextField textTo;
    public JTextField textFrom;
    public JTextField textAmount;

    public JLabel createLabel(String text) {
        return new JLabel(text);
    }

    public JTextField createTextField(String defaultValue) {
        return new JTextField(defaultValue);
    }

    public void cgui() {
        JFrame frame = new JFrame("Currency Converter");
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                converting_data converter_data = new converting_data();

                String currency_from = textFrom.getText();
                String currency_to = textTo.getText();
                String currency_amount_str = textAmount.getText();

                double currency_count_from = converter_data.Converter_from(currency_from);
                double currency_count_to = converter_data.Converter_to(currency_to);
                double currency_amount = Double.parseDouble(currency_amount_str);

                converter_data.Converter_counter(currency_amount, currency_count_to, currency_count_from);
            }
        });
        frame.setLayout(new GridBagLayout());
        frame.setLayout(new GridLayout(4, 2));

        JLabel labelFrom = createLabel("     Currency from:");
        JLabel labelTo = createLabel("     Currency to:");
        JLabel labelAmount = createLabel("     Amount:");


        textFrom = createTextField("");
        textTo = createTextField("");
        textAmount = createTextField("");

        frame.add(labelFrom);
        frame.add(textFrom);
        frame.add(labelTo);
        frame.add(textTo);
        frame.add(labelAmount);
        frame.add(textAmount);
        frame.add(new JLabel());
        frame.add(convertButton);

        frame.setSize(270, 125);
        frame.setMinimumSize(new Dimension(220, 105));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}