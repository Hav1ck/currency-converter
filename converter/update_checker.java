package converter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class update_checker {
    public static void main(String[] args) throws IOException {
        // Writing version information to a file
        FileWriter writer = new FileWriter("converter_info.txt");
        writer.write("version 1.0\n\nall information about currency rates was taken in 28.02.2024 and is not being updated\n");
        writer.close();

        // Reading information from the file
        Scanner reader = new Scanner(new File("converter_info.txt"));
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }
}
